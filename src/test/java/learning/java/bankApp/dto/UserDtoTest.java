package learning.java.bankApp.dto;

import jakarta.validation.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest
{
    static private Validator validator;
    
    @BeforeAll
    static void setUp(){
        try(ValidatorFactory factory = Validation.buildDefaultValidatorFactory())
        {
            validator = factory.getValidator();
        };
    }

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
        UserDto userDto = new UserDto(null,VALID_NAME,VALID_AGENCY,VALID_ACCOUNT_NUMBER,
                VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        
        Set<ConstraintViolation<UserDto>> violations = validator.validate(userDto);
        assertTrue(violations.isEmpty());
    }

    private final String INVALID_NULL_STRING = null;
    private final String INVALID_EMPTY = "";
    private final BigDecimal INVALID_NULL_BIG_DECIMAL = null;
    private final BigDecimal INVALID_NEGATIVE = new BigDecimal(-0.01);
    private final BigDecimal INVALID_ZERO = BigDecimal.ZERO;

    @Test
    public void shouldFailWithInvalidName()
    {
        UserDto userDto;
        Set<ConstraintViolation<UserDto>> violations;

        userDto = new UserDto(null, INVALID_NULL_STRING,VALID_AGENCY,VALID_ACCOUNT_NUMBER, VALID_ACCOUNT_BALANCE,
                    VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());

        userDto = new UserDto(null, INVALID_EMPTY, VALID_AGENCY,VALID_ACCOUNT_NUMBER, VALID_ACCOUNT_BALANCE,
                    VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());
    }

    @Test
    public void shouldFailWithInvalidAccountAgency()
    {
        UserDto userDto;
        Set<ConstraintViolation<UserDto>> violations;

        userDto = new UserDto(null, VALID_NAME, INVALID_NULL_STRING,VALID_ACCOUNT_NUMBER,
                    VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());

        userDto =
            new UserDto(null, VALID_NAME,INVALID_EMPTY,VALID_ACCOUNT_NUMBER ,
                    VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());
    }

    @Test
    public void shouldFailWithInvalidAccountNumber()
    {
        UserDto userDto;
        Set<ConstraintViolation<UserDto>> violations;

        userDto = new UserDto(null, VALID_NAME,VALID_AGENCY, INVALID_NULL_STRING,
                    VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());

        userDto = new UserDto(null, VALID_NAME,VALID_AGENCY, INVALID_EMPTY,
                    VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());
    }

    @Test
    public void shouldFailExceptionWithInvalidAccountBalance()
    {
        UserDto userDto;
        Set<ConstraintViolation<UserDto>> violations;

        userDto = new UserDto(null, VALID_NAME,VALID_AGENCY, VALID_ACCOUNT_NUMBER, INVALID_NULL_BIG_DECIMAL,
                    VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());
    }

    @Test
    public void shouldFailWithInvalidAccountCreditLimit()
    {
        UserDto userDto;
        Set<ConstraintViolation<UserDto>> violations;

        userDto = new UserDto(null, VALID_NAME,VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                    VALID_ACCOUNT_BALANCE, INVALID_NULL_BIG_DECIMAL, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());

        userDto = new UserDto(null, VALID_NAME,VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                    VALID_ACCOUNT_BALANCE, INVALID_NEGATIVE, VALID_CARD_NUMBER, VALID_CARD_LIMIT);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());
    }

    @Test
    public void shouldFailWithInvalidCardNumber()
    {
        UserDto userDto;
        Set<ConstraintViolation<UserDto>> violations;

        userDto = new UserDto(null, VALID_NAME,VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                    VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, INVALID_NULL_STRING, VALID_CARD_LIMIT);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());

        userDto = new UserDto(null, VALID_NAME,VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                    VALID_ACCOUNT_BALANCE, INVALID_NEGATIVE, INVALID_EMPTY, VALID_CARD_LIMIT);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());
    }

    @Test
    public void shouldFailWithInvalidCardLimit() {
        UserDto userDto;
        Set<ConstraintViolation<UserDto>> violations;

        userDto = new UserDto(null, VALID_NAME, VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, INVALID_NULL_BIG_DECIMAL);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());

        userDto = new UserDto(null, VALID_NAME, VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, INVALID_ZERO);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());

        userDto = new UserDto(null, VALID_NAME, VALID_AGENCY, VALID_ACCOUNT_NUMBER,
                VALID_ACCOUNT_BALANCE, VALID_ACCOUNT_CREDIT_LIMIT, VALID_CARD_NUMBER, INVALID_NEGATIVE);
        violations = validator.validate(userDto);
        assertTrue(!violations.isEmpty());
    }
}