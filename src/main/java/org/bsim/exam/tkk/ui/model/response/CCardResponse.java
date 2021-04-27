package org.bsim.exam.tkk.ui.model.response;

public class CCardResponse {
    private String cardSerialId;
    private String cardType;
    private long cardUsed;
    private long cardLimit;
    private boolean isDeleted;

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
}
