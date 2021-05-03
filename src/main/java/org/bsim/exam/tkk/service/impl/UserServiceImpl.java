package org.bsim.exam.tkk.service.impl;

import org.bsim.exam.tkk.io.entity.UserEntity;
import org.bsim.exam.tkk.io.irepository.UserRepository;
import org.bsim.exam.tkk.service.iservice.IUserInterface;
import org.bsim.exam.tkk.shared.dto.UserDTO;
import org.bsim.exam.tkk.shared.utils.GenerateRandomPublicId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserInterface {
    @Autowired
    UserRepository userRepository;

    @Autowired
    GenerateRandomPublicId generateRandomPublicId;

    @Override
    public UserDTO getUserByUserid(String userid) {
        UserEntity getUser = userRepository.findByUserId(userid);
        if (getUser == null)
            return null;
        return new ModelMapper().map(getUser, UserDTO.class);
    }

    @Override
    public UserDTO addNewData(UserDTO user) {
        user.setUserId(generateRandomPublicId.generateUserId(30));
        ModelMapper mapper = new ModelMapper();

        UserEntity entity = mapper.map(user, UserEntity.class);
        UserEntity storedData = userRepository.save(entity);
        UserDTO value = mapper.map(storedData, UserDTO.class);
        return value;
    }

    @Override
    public UserDTO deleteUser(String userid) {
        ModelMapper mapper = new ModelMapper();
        UserEntity userEntity = userRepository.findByUserId(userid);

        userEntity.setUserId(userid);
        userEntity.setDeleted(true);
        UserEntity value = userRepository.save(userEntity);
        return mapper.map(value,UserDTO.class);
    }

    @Override
    public UserDTO updateUserData(String userid, UserDTO userDTO) {
        UserEntity userEntity = userRepository.findByUserId(userid);

        if (userEntity == null){
            return null;
        }
        userEntity.setUserName(userDTO.getUserName());
        userEntity.setUserAddress(userDTO.getUserAddress());
        userEntity.setUserDOB(userDTO.getUserDOB());
        userEntity.setUserPhoneNumber(userDTO.getUserPhoneNumber());
        userEntity.setPassword(userDTO.getPassword());

        UserEntity updateData = userRepository.save(userEntity);
        return new ModelMapper().map(updateData,UserDTO.class);
    }
}
