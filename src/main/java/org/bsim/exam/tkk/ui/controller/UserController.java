package org.bsim.exam.tkk.ui.controller;

import org.bsim.exam.tkk.service.iservice.IUserInterface;
import org.bsim.exam.tkk.shared.dto.UserDTO;
import org.bsim.exam.tkk.ui.model.request.UserRequest;
import org.bsim.exam.tkk.ui.model.response.UserResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    IUserInterface userService;
    @GetMapping(path = "/{userid}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse getUserByUserid(@PathVariable String userid){
        UserDTO getUser = userService.getUserByUserid(userid);
        if (getUser == null) return null;
        return new ModelMapper().map(getUser, UserResponse.class);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse addNewUser(@RequestBody UserRequest user){
        ModelMapper mapper = new ModelMapper();
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        UserDTO createdUser = userService.addNewData(userDTO);
        UserResponse response = mapper.map(createdUser, UserResponse.class);
        return response;
    }

    @PutMapping(path = "/{userid}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse updateUserData(@PathVariable String userid,
                                       @RequestBody UserRequest userRequest){
        ModelMapper mapper = new ModelMapper();
        UserDTO userDTO = mapper.map(userRequest, UserDTO.class);
        UserDTO updateData = userService.updateUserData(userid,userDTO);
        return mapper.map(updateData , UserResponse.class);
    }

    @DeleteMapping(path = "/{userid}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UserResponse deleteUser (@PathVariable String userid){
        ModelMapper mapper = new ModelMapper();
        UserDTO userDTO = userService.deleteUser(userid);
        return mapper.map(userDTO, UserResponse.class);
    }
}
