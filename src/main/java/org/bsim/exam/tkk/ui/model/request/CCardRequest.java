package org.bsim.exam.tkk.ui.model.request;

import org.springframework.stereotype.Service;

@Service
public class CCardRequest {
    private String cardType;

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
