package learning.java.bankApp.dto;

import java.math.BigDecimal;

public class UserDtoBuilder
{
    private String name = null;
    private String accountAgency = null;
    private String accountNumber = null;
    private BigDecimal accountBalance = null;
    private BigDecimal accountCreditLimit = null;
    private String cardNumber = null;
    private BigDecimal cardLimit = null;

    public UserDtoBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserDtoBuilder accountAgency(String accountAgency) {
        this.accountAgency = accountAgency;
        return this;
    }

    public UserDtoBuilder accountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
        return this;
    }

    public UserDtoBuilder accountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
        return this;
    }

    public UserDtoBuilder accountCreditLimit(BigDecimal accountCreditLimit) {
        this.accountCreditLimit = accountCreditLimit;
        return this;
    }

    public UserDtoBuilder cardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
        return this;
    }

    public UserDtoBuilder cardLimit(BigDecimal cardLimit) {
        this.cardLimit = cardLimit;
        return this;
    }

    public UserDto build() {

        return new UserDto(name,accountAgency,accountNumber,accountBalance,accountCreditLimit,cardNumber,cardLimit);
    }
}
