package learning.java.bankApp.dto;

import jakarta.validation.constraints.*;


import java.math.BigDecimal;

public record UserDto(

        Long id,

        @NotBlank(message = "'name' cannot be 'null' or 'empty'.")
        @Size(min=5, max=35, message="length of 'name' should be in range [5,35].")
        String name,

        @NotBlank(message = "'accountAgency' cannot be 'null' or 'empty'.")
        String accountAgency,

        @NotBlank(message = "'accountNumber' cannot be 'null' or 'empty'.")
        String accountNumber,

        @NotNull(message = "'accountBalance' cannot be 'null'.")
        BigDecimal accountBalance,

        @NotNull(message = "'accountCreditLimit' cannot be 'null'.")
        @PositiveOrZero(message = "'accountCreditLimit' cannot be negative.")
        BigDecimal accountCreditLimit,

        @NotBlank(message = "'cardNumber' cannot be 'null' or 'empty'.")
        String cardNumber,

        @NotNull(message = "'cardLimit' cannot be null.")
        @Positive(message = "'cardLimit' should be greater than zero." )
        BigDecimal cardLimit)
{
   //nothing for while
/*
    public UserDto
    {
        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("'name' cannot be null or empty");

        if(accountAgency == null || accountAgency.isEmpty())
            throw new IllegalArgumentException();

        if(accountNumber == null || accountNumber.isEmpty())
            throw new IllegalArgumentException("'accountNumber' cannot be null or empty");

        if(accountBalance == null)
            throw new IllegalArgumentException("'accountBalance' cannot be null or empty");

        if(accountCreditLimit == null || accountCreditLimit.compareTo(BigDecimal.ZERO) == 0)
            throw new IllegalArgumentException("'accountCreditLimit' cannot be negative");

        if(cardNumber == null || cardNumber.isEmpty())
            throw new IllegalArgumentException("'cardNumber' cannot be null or empty");

        if(cardLimit == null || cardLimit.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("'cardLimit' cannot be negative");
    }

 */
}
