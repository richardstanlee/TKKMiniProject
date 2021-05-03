package org.bsim.exam.tkk.shared.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TransactionDTO implements Serializable {
    private static final long serialVersionUID = -9119327771288963564L;

    private long ID;
    private String transactionID;
    private String note;
    private long amount;
    private LocalDateTime date;
    private boolean isDeleted;
    private CCardDTO cCardDTO;

    public long getId() {
        return ID;
    }

    public void setId(long id) {
        this.ID = id;
    }

    public String getTransactionId() {
        return transactionID;
    }

    public void setTransactionId(String transactionId) {
        this.transactionID = transactionId;
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

