package org.bsim.exam.tkk.shared.dto;

import java.io.Serializable;

public class CCardDTO implements Serializable {

    private static final long serialVersionUID= 3412108276913856511L;
    private long id;
    private String cardSerialId;
    private String cardType;
    private long cardUsed;
    private long cardLimit;
    private boolean isDeleted;
    private UserDTO userDTO;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardSerialId() {
        return cardSerialId;
    }

    public void setCardSerialId(String cardSerialId) {
        this.cardSerialId = cardSerialId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public long getCardUsed() {
        return cardUsed;
    }

    public void setCardUsed(long cardUsed) {
        this.cardUsed = cardUsed;
    }

    public long getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(long cardLimit) {
        this.cardLimit = cardLimit;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
