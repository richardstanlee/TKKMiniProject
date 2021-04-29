package org.bsim.exam.tkk.service.iservice;

import org.bsim.exam.tkk.shared.dto.UserDTO;

public interface IUserInterface {
    UserDTO getUserByUserid(String userid);
    UserDTO addNewData(UserDTO user);
    UserDTO deleteUser(String userid);
    UserDTO updateUserData(String userid, UserDTO userDTO);
}
