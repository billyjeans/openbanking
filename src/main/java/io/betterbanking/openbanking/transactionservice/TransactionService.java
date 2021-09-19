package io.betterbanking.openbanking.transactionservice;


import io.betterbanking.openbanking.model.TransactionInformation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TransactionService {
    public List<TransactionInformation> getAllForAccountNumber(String accountNumber) {
        List<TransactionInformation> transactions= new ArrayList<>();
        TransactionInformation t1 = TransactionInformation.builder().accountNumber("01").date(LocalDate.now()).eTransactionType(TransactionInformation.ETransactionType.E_BILL_PAYMENT_TRANSACTION).build();
        TransactionInformation t2 = TransactionInformation.builder().accountNumber("02").date(LocalDate.now()).eTransactionType(TransactionInformation.ETransactionType.CREDIT_CARD_TRANSACTTION).build();
        TransactionInformation t3 = TransactionInformation.builder().accountNumber("03").date(LocalDate.now()).eTransactionType(TransactionInformation.ETransactionType.WIRE_TRANSFER).build();
        TransactionInformation t4 = TransactionInformation.builder().accountNumber("04").date(LocalDate.now()).eTransactionType(TransactionInformation.ETransactionType.E_BILL_PAYMENT_TRANSACTION).build();
        TransactionInformation t5 = TransactionInformation.builder().accountNumber("05").date(LocalDate.now()).eTransactionType(TransactionInformation.ETransactionType.CREDIT_CARD_TRANSACTTION).build();

        return Arrays.asList(t1,t2,t3,t4,t5);
    }
}
