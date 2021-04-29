package org.bsim.exam.tkk.io.entity;

import org.bsim.exam.tkk.shared.dto.UserDTO;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CCardTBL")
@SequenceGenerator(name = "seqCC", initialValue = 1 , allocationSize = 0)
public class CCardEntity implements Serializable {
    private static final long serialVersionUID = -9213882945795366542L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCC")
    private long id;

    @Column(nullable = false)
    private String cardSerialId;

    @Column(nullable = false)
    private String cardType;

    private long cardUsed = 0;

    private long cardLimit;

    private boolean isDeleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private UserEntity user;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<TransactionEntity> transactionEntity = new ArrayList<>();

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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<TransactionEntity> getTransactionEntity() {
        return transactionEntity;
    }

    public void setTransactionEntity(List<TransactionEntity> transactionEntity) {
        this.transactionEntity = transactionEntity;
    }
}
