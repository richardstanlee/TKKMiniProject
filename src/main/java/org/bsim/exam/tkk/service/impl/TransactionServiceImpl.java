package org.bsim.exam.tkk.service.impl;

import org.bsim.exam.tkk.io.entity.CCardEntity;
import org.bsim.exam.tkk.io.entity.TransactionEntity;
import org.bsim.exam.tkk.io.irepository.CCardRepository;
import org.bsim.exam.tkk.io.irepository.TransactionRepository;
import org.bsim.exam.tkk.service.iservice.ITransactionService;
import org.bsim.exam.tkk.shared.dto.TransactionDTO;
import org.bsim.exam.tkk.shared.utils.GenerateRandomPublicId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CCardRepository cCardRepository;
    @Autowired
    GenerateRandomPublicId generateRandomPublicId;

    @Override
    public List<TransactionDTO> getAllTransaction() {
        ModelMapper mapper = new ModelMapper();

        List<TransactionDTO> value = new ArrayList<>();
        List<TransactionEntity> transactionEntities = transactionRepository.findAll();
        for (TransactionEntity entity : transactionEntities){
            value.add(mapper.map(entity , TransactionDTO.class));
        }
        return value;
    }

    @Override
    public List<TransactionDTO> getAllTransactionBycardSerialId(String cardSerialId) {
        List<TransactionDTO> value = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();

        CCardEntity cCardEntity = cCardRepository.findByCardSerialId(cardSerialId);
        List<TransactionEntity> transactionEntities = transactionRepository.findByCard(cCardEntity);
        for (TransactionEntity entity : transactionEntities){
            value.add(mapper.map(entity , TransactionDTO.class));
        }
        return value;
    }

    @Override
    public TransactionDTO addNewTransaction(String cardSerialId, TransactionDTO transactionsDTO) {
        ModelMapper mapper = new ModelMapper();
        long used = 0;
        long amountInit = 0;

        CCardEntity cCardEntity = cCardRepository.findByCardSerialId(cardSerialId);
        used = cCardEntity.getCardUsed();
        amountInit = transactionsDTO.getAmount();
        cCardEntity.setCardUsed(used + amountInit);
        cCardRepository.save(cCardEntity);

        TransactionEntity entity = mapper.map(transactionsDTO , TransactionEntity.class);
        entity.setCard(cCardEntity);
        entity.setTransactionId(generateRandomPublicId.generateUserId(35));

        TransactionEntity storedValue = transactionRepository.save(entity);
        TransactionDTO value = mapper.map(storedValue , TransactionDTO.class);
        return value;
    }



    @Override
    public TransactionDTO updateTransactionByTransactionId(String cardSerialId, String transactionId, TransactionDTO transactionsDTO) {
        ModelMapper mapper = new ModelMapper();

        long cardUsedInit = 0;
        long amountInit = 0;
        long amountUpdate = transactionsDTO.getAmount();

        CCardEntity cCardEntity = cCardRepository.findByCardSerialId(cardSerialId);
        TransactionEntity transactionEntity = transactionRepository.findByTransactionId(transactionId);
        cardUsedInit = cCardEntity.getCardUsed();
        amountInit = transactionEntity.getAmount();

        TransactionEntity entity = mapper.map(transactionsDTO,TransactionEntity.class);
        entity.setCard(cCardEntity);
        entity.setId(transactionEntity.getId());
        entity.setTransactionId(transactionEntity.getTransactionId());

        if (amountInit - amountUpdate > 0 ){
            cCardEntity.setCardUsed(cardUsedInit + (amountUpdate - amountInit));
        }else{
            cCardEntity.setCardUsed(cardUsedInit - (amountUpdate - amountInit));
        }
        cCardRepository.save(cCardEntity);

        TransactionEntity value = transactionRepository.save(entity);
        return mapper.map(value,TransactionDTO.class);
    }

    @Override
    public TransactionDTO deleteTransaction(String cardSerialId, String transactionId) {
        ModelMapper mapper = new ModelMapper();
        CCardEntity cCardEntity = cCardRepository.findByCardSerialId(cardSerialId);
        TransactionEntity transactionEntity = transactionRepository.findByTransactionId(transactionId);

        transactionEntity.setCard(cCardEntity);
        transactionEntity.setDeleted(true);
        TransactionEntity value = transactionRepository.save(transactionEntity);
        return mapper.map(value,TransactionDTO.class);
    }

}
