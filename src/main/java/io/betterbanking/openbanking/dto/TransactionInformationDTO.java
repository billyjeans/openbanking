package io.betterbanking.openbanking.dto;

import io.betterbanking.openbanking.model.TransactionInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@SuperBuilder
public class TransactionInformationDTO {
    private LocalDate date;
    private String accountNumber;
    private String currency;
    private String merchantName;
    private String merchantLogo;
    private TransactionInformation.ETransactionType ETransactionType;
}
