package org.bsim.exam.tkk.ui.controller;

import org.bsim.exam.tkk.service.iservice.ITransactionService;
import org.bsim.exam.tkk.shared.dto.TransactionDTO;
import org.bsim.exam.tkk.ui.model.request.TransactionRequest;
import org.bsim.exam.tkk.ui.model.response.TransactionResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @Autowired
    ITransactionService iTransactionService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TransactionResponse> getAllTransaction(){
        ModelMapper mapper = new ModelMapper();
        List<TransactionResponse> value = new ArrayList<>();
        List<TransactionDTO> transactionsDTO = iTransactionService.getAllTransaction();

        for (TransactionDTO dto : transactionsDTO){
            value.add(mapper.map(dto, TransactionResponse.class));
        }
        return value;
    }

    @GetMapping(path = "/{cardSerialId}" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TransactionResponse> getAllTransactionByWalletId(@PathVariable String cardSerialId){
        ModelMapper mapper = new ModelMapper();
        List<TransactionResponse> value = new ArrayList<>();

        List<TransactionDTO> allTransaction = iTransactionService.getAllTransactionBycardSerialId(cardSerialId);

        for (TransactionDTO dto : allTransaction){
            value.add(mapper.map(dto , TransactionResponse.class));
        }
        return value;
    }

    @PostMapping(path = "/{cardSerialId}" , consumes = {MediaType.APPLICATION_JSON_VALUE} , produces = {MediaType.APPLICATION_JSON_VALUE})
    public TransactionResponse addNewTransaction(@PathVariable String cardSerialId, @RequestBody TransactionRequest transactionRequest){
        ModelMapper mapper = new ModelMapper();

        TransactionDTO transactionsDTO = mapper.map(transactionRequest , TransactionDTO.class);

        TransactionDTO storedValue = iTransactionService.addNewTransaction(cardSerialId, transactionsDTO);

        TransactionResponse value = mapper.map(storedValue , TransactionResponse.class);
        return value ;
    }

    @PutMapping(path = "/{cardSerialId}/{transactionId}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public TransactionResponse updateTransactionByTransactionId(@PathVariable String cardSerialId, @PathVariable String transactionId , @RequestBody TransactionRequest transactionRequset){
        ModelMapper mapper = new ModelMapper();
        TransactionDTO transactionsDTO = mapper.map(transactionRequset, TransactionDTO.class);

        TransactionDTO updatedData = iTransactionService.updateTransactionByTransactionId(cardSerialId,transactionId,transactionsDTO);


        return mapper.map(updatedData, TransactionResponse.class);
    }

    @DeleteMapping(path = "/{cardSerialId}/{transactionId}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public TransactionResponse deleteTransaction (@PathVariable String cardSerialId, @PathVariable String transactionId){
        ModelMapper mapper = new ModelMapper();
        TransactionDTO transactionsDTO = iTransactionService.deleteTransaction(cardSerialId,transactionId);


        return mapper.map(transactionsDTO, TransactionResponse.class);
    }
}
