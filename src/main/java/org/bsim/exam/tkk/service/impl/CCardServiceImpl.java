package org.bsim.exam.tkk.service.impl;

import org.bsim.exam.tkk.io.entity.CCardEntity;
import org.bsim.exam.tkk.io.entity.UserEntity;
import org.bsim.exam.tkk.io.irepository.CCardRepository;
import org.bsim.exam.tkk.io.irepository.UserRepository;
import org.bsim.exam.tkk.service.iservice.ICCardService;
import org.bsim.exam.tkk.shared.dto.CCardDTO;
import org.bsim.exam.tkk.shared.dto.UserDTO;
import org.bsim.exam.tkk.shared.utils.GenerateRandomPublicId;
import org.bsim.exam.tkk.ui.model.request.CCardRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CCardServiceImpl implements ICCardService {
    @Autowired
    CCardRepository cCardRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    GenerateRandomPublicId generateRandomPublicId;

    @Override
    public CCardDTO addNewCCardData(String userid, CCardDTO cCardDTO) {
        ModelMapper mapper = new ModelMapper();
        String type = "";

        type = cCardDTO.getCardType();

        if (type.equals("Silver")){
            cCardDTO.setCardLimit(100000000);
        }else if (type.equals("Gold")){
            cCardDTO.setCardLimit(500000000);
        }else if (type.equals("Platinum")){
            cCardDTO.setCardLimit(2000000000);
        }

        cCardDTO.setCardSerialId(generateRandomPublicId.generateUserId(30));

        UserEntity userData = userRepository.findByUserId(userid);
        cCardDTO.setUserDTO(mapper.map(userData, UserDTO.class));

        CCardEntity entity = mapper.map(cCardDTO, CCardEntity.class);

        CCardEntity storedData = cCardRepository.save(entity);

        return mapper.map(storedData, CCardDTO.class);
    }

    @Override
    public List<CCardDTO> getAllCardsData(String userid) {
        ModelMapper mapper = new ModelMapper();

        List<CCardDTO> value = new ArrayList<>();

        UserEntity userEntity = userRepository.findByUserId(userid);

        List<CCardEntity> cardsData = cCardRepository.findAllByUser(userEntity);

        for (CCardEntity cCardEntity : cardsData){
            value.add(mapper.map(cCardEntity, CCardDTO.class));
        }
        return value;
    }

    @Override
    public CCardDTO deleteCreditCard(String userid, String cardSerialId) {
        ModelMapper mapper = new ModelMapper();
        UserEntity userEntity = userRepository.findByUserId(userid);
        CCardEntity cCardEntity = cCardRepository.findByCardSerialId(cardSerialId);

        cCardEntity.setUser(userEntity);
        cCardEntity.setDeleted(true);

        CCardEntity value = cCardRepository.save(cCardEntity);


        return mapper.map(value,CCardDTO.class);
    }

    @Override
    public CCardDTO updateCardData(String userid, String cardSerialId, CCardDTO cCardDTO) {
        UserEntity userEntity = userRepository.findByUserId(userid);
        CCardEntity cCardEntity = cCardRepository.findByCardSerialId(cardSerialId);

        if (cCardEntity == null){
            return null;
        }
        cCardEntity.setCardType(cCardDTO.getCardType());

        CCardEntity updateData = cCardRepository.save(cCardEntity);

        return new ModelMapper().map(updateData,CCardDTO.class);
    }


}
