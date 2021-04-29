package org.bsim.exam.tkk.io.irepository;

import org.bsim.exam.tkk.io.entity.CCardEntity;
import org.bsim.exam.tkk.io.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    List<TransactionEntity> findByCard(CCardEntity cCardEntity);
    TransactionEntity findByTransactionId(String transactionId);
}
