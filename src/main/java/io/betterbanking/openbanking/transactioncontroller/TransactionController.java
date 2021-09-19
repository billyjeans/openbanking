package io.betterbanking.openbanking.transactioncontroller;

import io.betterbanking.openbanking.dto.TransactionInformationDTO;
import io.betterbanking.openbanking.model.TransactionInformation;
import io.betterbanking.openbanking.transactionservice.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/transactions")
@RestController
@CrossOrigin(origins = "/*")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping(path = "/{accountNumber}")
    public List<TransactionInformationDTO> findAllByAccountNumber(@PathVariable ("accountNumber") String accountNumber) {
        List<TransactionInformation> transactions = transactionService.getAllForAccountNumber(accountNumber);
        return mapTransactionsToDTOList(transactions);

    }

    private List<TransactionInformationDTO> mapTransactionsToDTOList(List<TransactionInformation> transactions) {
        List<TransactionInformationDTO> transactionDto = new ArrayList<>();
        return transactions.stream().map(transactionInformation -> TransactionInformationDTO.builder()
                .merchantName(transactionInformation.getMerchantNmae())
                .accountNumber(transactionInformation.getAccountNumber())
                .ETransactionType(transactionInformation.getETransactionType())
                .date(transactionInformation.getDate())
                .merchantLogo(transactionInformation.getMerchantLogo())
                .build()).collect(Collectors.toList());
    }
}
