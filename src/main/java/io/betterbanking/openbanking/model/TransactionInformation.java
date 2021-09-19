package io.betterbanking.openbanking.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Further details of the transaction.  This is the transaction narrative, which is unstructured text.
 */

@Data
@SuperBuilder
@NoArgsConstructor
@Validated
@ToString(callSuper = true)
@EqualsAndHashCode
@Entity
@Table(name = "TRANSACTION")
public class TransactionInformation {

    @Id
    @SequenceGenerator(name = "hibernate_sequence", allocationSize = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "DATE")
    private LocalDate date;

    @NotNull
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @NotNull
    @Column(name = "CURRENCY")
    private String currency;

    @NotNull
    @Column(name = "MERCHANT_NAME")
    private String merchantNmae;

    @NotNull
    @Column(name = "MERCHANT_LOGO")
    private String merchantLogo;

    @NotNull
    @Column(name = "TRANSACTION_TYPE")
    @Enumerated(value = EnumType.STRING)
    private ETransactionType eTransactionType;


    public enum ETransactionType {
        WIRE_TRANSFER("WIRE_TRANSFER_TRANSACTION"),
        CREDIT_CARD_TRANSACTTION("CREDIT_CARD_TRANSACTION"),
        E_BILL_PAYMENT_TRANSACTION("E_BILL_TRANSACTION"),
        UNKNOWN("UNKNOWN");
        private String code;

        ETransactionType(String s) {
            this.code = s;
        }

        public static ETransactionType getTransactionType(String code) {
            for (ETransactionType value : ETransactionType.values()) {
                if (value.equals(code)) {
                    return value;
                }
            }
            return UNKNOWN;
        }
    }
}
