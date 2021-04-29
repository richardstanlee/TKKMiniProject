package org.bsim.exam.tkk.ui.model.response;

import org.bsim.exam.tkk.shared.dto.CCardDTO;

import java.time.LocalDateTime;

public class TransactionResponse {
    private String transactionId;
    private String note;
    private long amount;
    private LocalDateTime date;
    private boolean isDeleted;
    private CCardDTO cCardDTO;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public CCardDTO getcCardDTO() {
        return cCardDTO;
    }

    public void setcCardDTO(CCardDTO cCardDTO) {
        this.cCardDTO = cCardDTO;
    }
}
