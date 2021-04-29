package org.bsim.exam.tkk.io.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactionTBL")
public class TransactionEntity implements Serializable {
    private static final long serialVersionUID = 9040161796481214210L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;

    @Column(nullable = false)
    private String note;

    @Column(nullable = false)
    private long amount;

    @Column(nullable = false)
    private LocalDateTime date;

    private boolean isDeleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cardSerialId")
    private CCardEntity card;

    @Column(nullable = false)
    private String transactionId;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public CCardEntity getCard() {
        return card;
    }

    public void setCard(CCardEntity card) {
        this.card = card;
    }
}
