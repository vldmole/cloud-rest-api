package learning.java.bankApp.dto;

import java.math.BigDecimal;

public class UserDtoBuilder
{
    private Long id = null;
    private String name = null;
    private String accountAgency = null;
    private String accountNumber = null;
    private BigDecimal accountBalance = null;
    private BigDecimal accountCreditLimit = null;
    private String cardNumber = null;
    private BigDecimal cardLimit = null;

    public void reset()
    {
        this.id = null;
        this.name = null;
        this.accountAgency = null;
        this.accountNumber = null;
        this.accountBalance = null;
        this.accountCreditLimit = null;
        this.cardNumber = null;
        this.cardLimit = null;
    }

    public UserDtoBuilder id(Long id){
        this.id = id;
        return this;
    }

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

        UserDto dto = new UserDto(
                id,
                name,
                accountAgency,
                accountNumber,
                accountBalance,
                accountCreditLimit,
                cardNumber,
                cardLimit
        );

        this.reset();

        return dto;
    }
}
