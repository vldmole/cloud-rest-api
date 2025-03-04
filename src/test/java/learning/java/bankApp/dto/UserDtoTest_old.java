package learning.java.bankApp.dto;

import jakarta.validation.ValidationException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
/*
class UserDtoTest_old
{
    private final String VALID_NAME = "John Stuart";
    private final String VALID_AGENCY = "1234";
    private final String VALID_ACCOUNT_NUMBER = "92345";
    private BigDecimal VALID_ACCOUNT_BALANCE = BigDecimal.ZERO;
    private BigDecimal VALID_ACCOUNT_CREDIT_LIMIT = BigDecimal.ZERO;
    private String VALID_CARD_NUMBER = "123456789";
    private BigDecimal VALID_CARD_LIMIT = BigDecimal.ONE;

    @Test
    public void shouldInstantiateWithoutThrows()
    {
        assertDoesNotThrow(()->new UserDto(VALID_NAME,VALID_AGENCY,VALID_ACCOUNT_NUMBER,
                VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT));
    }

    private final String INVALID_NULL_STRING = null;
    private final String INVALID_EMPTY = "";
    private final BigDecimal INVALID_NULL_BIG_DECIMAL = null;
    private final BigDecimal INVALID_NEGATIVE = new BigDecimal(-0.01);
    private final BigDecimal INVALID_ZERO = BigDecimal.ZERO;

    @Test
    public void shouldThrowsWithInvalidName()
    {
        assertThrows(IllegalArgumentException.class, ()->{
            new UserDto(INVALID_NULL_STRING,VALID_AGENCY,VALID_ACCOUNT_NUMBER, VALID_ACCOUNT_BALANCE,
                    VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        });

        assertThrows(IllegalArgumentException.class, ()->{
            new UserDto(INVALID_EMPTY, VALID_AGENCY,VALID_ACCOUNT_NUMBER, VALID_ACCOUNT_BALANCE,
                    VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        });
    }

    @Test
    public void shouldThrowsWithInvalidAccountAgency()
    {
        assertThrows(IllegalArgumentException.class, ()->{
            new UserDto(VALID_NAME, INVALID_NULL_STRING,VALID_ACCOUNT_NUMBER,
                    VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        });

        assertThrows(IllegalArgumentException.class, ()->{
            new UserDto(VALID_NAME,INVALID_EMPTY,VALID_ACCOUNT_NUMBER ,
                    VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        });
    }

    @Test
    public void shouldThrowsWithInvalidAccountNumber()
    {
        assertThrows(IllegalArgumentException.class, ()->{
            new UserDto(VALID_NAME,VALID_AGENCY, INVALID_NULL_STRING,
                    VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        });

        assertThrows(IllegalArgumentException.class, ()->{
            new UserDto(VALID_NAME,VALID_AGENCY, INVALID_EMPTY,
                    VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        });
    }

    @Test
    public void shouldThrowsExceptionWithInvalidAccountBalance()
    {
        assertThrows(IllegalArgumentException.class, ()->{
            new UserDto(VALID_NAME,VALID_AGENCY, VALID_ACCOUNT_NUMBER, INVALID_NULL_BIG_DECIMAL,
                    VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        });
    }

    @Test
    public void shouldThrowsWithInvalidAccountCreditLimit()
    {
        assertThrows(ValidationException.class, ()->{
            new UserDto(VALID_NAME,VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                    VALID_ACCOUNT_BALANCE, INVALID_NULL_BIG_DECIMAL, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        });

        assertThrows(ValidationException.class, ()->{
            new UserDto(VALID_NAME,VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                    VALID_ACCOUNT_BALANCE, INVALID_NEGATIVE, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        });
    }

    @Test
    public void shouldThrowsWithInvalidCardNumber()
    {
        assertThrows(IllegalArgumentException.class, ()->{
            new UserDto(VALID_NAME,VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                    VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, INVALID_NULL_STRING, VALID_CARD_LIMIT);
        });

        assertThrows(IllegalArgumentException.class, ()->{
            new UserDto(VALID_NAME,VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                    VALID_ACCOUNT_BALANCE, INVALID_NEGATIVE, INVALID_EMPTY, VALID_CARD_LIMIT);
        });
    }

    @Test
    public void shouldThrowsWithInvalidCardLimit()
    {
        assertThrows(IllegalArgumentException.class, ()->{
            new UserDto(VALID_NAME,VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                    VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, INVALID_NULL_BIG_DECIMAL);
        });

        assertThrows(IllegalArgumentException.class, ()->{
            new UserDto(VALID_NAME,VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                    VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, INVALID_ZERO);
        });

        assertThrows(IllegalArgumentException.class, ()->{
            new UserDto(VALID_NAME,VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                    VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, INVALID_NEGATIVE);
        });
    }
}*/