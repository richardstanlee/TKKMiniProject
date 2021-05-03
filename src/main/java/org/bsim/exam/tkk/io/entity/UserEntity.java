package org.bsim.exam.tkk.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userTBL")
@SequenceGenerator(name = "seqUSR", initialValue = 1 , allocationSize = 0)
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 6811284072084028236L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUSR")
    private long ID;

    @Column(nullable = false)
    private String userID;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private LocalDateTime userDOB;

    @Column(nullable = false)
    private String userAddress;

    @Column(nullable = false)
    private String userPhoneNumber;

    @Column(nullable = false)
    private String password;

    private boolean isDeleted = false;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<CCardEntity> cCardEntities = new ArrayList<>();

    public long getId() {
        return ID;
    }

    public void setId(long id) {
        this.ID = id;
    }

    public String getUserId() {
        return userID;
    }

    public void setUserId(String userId) {
        this.userID = userId;
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

    public List<CCardEntity> getcCardEntities() {
        return cCardEntities;
    }

    public void setcCardEntities(List<CCardEntity> cCardEntities) {
        this.cCardEntities = cCardEntities;
    }
}
