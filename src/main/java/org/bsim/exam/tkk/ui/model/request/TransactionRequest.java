package org.bsim.exam.tkk.ui.model.request;

import java.time.LocalDateTime;

public class TransactionRequest {
    private String note;
    private long amount;
    private LocalDateTime date;

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
}
