package org.bsim.exam.tkk.ui.model.request;

import java.time.LocalDateTime;

public class UserRequest {
    private String userName;
    private LocalDateTime userDOB;
    private String userAddress;
    private String userPhoneNumber;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDateTime getUserDOB() {
        return userDOB;
    }

    public void setUserDOB(LocalDateTime userDOB) {
        this.userDOB = userDOB;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
