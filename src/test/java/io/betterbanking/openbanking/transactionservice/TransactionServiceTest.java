package io.betterbanking.openbanking.transactionservice;

import io.betterbanking.openbanking.model.TransactionInformation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TransactionService.class)
public class TransactionServiceTest {
    @Autowired
     private TransactionService transactionService;



    @Test
    public void getAllForAccountNumber() {
        List<TransactionInformation> transactionInformationList = transactionService.getAllForAccountNumber("123");
        Assert.isTrue(transactionInformationList.size()==5, "succes");
    }
// checks if context loads properly and bean autowired properly
    @Test
    public void contextLoads() {
       Assertions.assertThat(transactionService).isNotNull();
    }
}
