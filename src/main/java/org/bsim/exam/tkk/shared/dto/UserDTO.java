package org.bsim.exam.tkk.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = -7415598351663017642L;
    private long id;
    private String userId;
    private String userName;
    private LocalDateTime userDOB;
    private String userAddress;
    private String userPhoneNumber;
    private String password;
    private boolean isDeleted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
