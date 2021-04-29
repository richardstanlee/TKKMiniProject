package org.bsim.exam.tkk.service.iservice;

import org.bsim.exam.tkk.shared.dto.TransactionDTO;

import java.util.List;

public interface ITransactionService {
    List<TransactionDTO> getAllTransaction();

    List<TransactionDTO> getAllTransactionBycardSerialId(String cardSerialId);

    TransactionDTO addNewTransaction(String cardSerialId, TransactionDTO transactionsDTO);

    TransactionDTO updateTransactionByTransactionId(String cardSerialId, String transactionId, TransactionDTO transactionsDTO);

    TransactionDTO deleteTransaction(String cardSerialId, String transactionId);


}
