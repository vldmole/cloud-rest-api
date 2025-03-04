package learning.java.bankApp.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserDtoBuilderTest
{
    private final String VALID_NAME = "John Stuart";
    private final String VALID_AGENCY = "1234";
    private final String VALID_ACCOUNT_NUMBER = "92345";
    private final BigDecimal VALID_ACCOUNT_BALANCE = BigDecimal.ZERO;
    private final BigDecimal VALID_ACCOUNT_CREDIT_LIMIT = BigDecimal.ZERO;
    private final String VALID_CARD_NUMBER = "123456789";
    private final BigDecimal VALID_CARD_LIMIT = BigDecimal.ONE;

    static private Validator validator;

    @BeforeAll
    static void setUp(){
        try(ValidatorFactory factory = Validation.buildDefaultValidatorFactory())
        {
            validator = factory.getValidator();
        };
    }

    @Test
    public void shouldNotFailWithAllBuildSteps()
    {
        UserDtoBuilder builder = new UserDtoBuilder();

        UserDto userDto = builder.name(VALID_NAME)
                .accountAgency(VALID_AGENCY)
                .accountNumber(VALID_ACCOUNT_NUMBER)
                .accountBalance(VALID_ACCOUNT_BALANCE)
                .accountCreditLimit(VALID_ACCOUNT_CREDIT_LIMIT)
                .cardNumber(VALID_CARD_NUMBER)
                .cardLimit(VALID_CARD_LIMIT)
                .build();

        Set<ConstraintViolation<UserDto>> violations = validator.validate(builder.build());
        assertTrue(violations.isEmpty());
    }

    @ParameterizedTest
    @ValueSource (ints = {1,2,3,4,5,6,7})
    public void shouldFailWithInsufficientBuildSteps(int stepToIgnore)
    {
        UserDtoBuilder builder = new UserDtoBuilder();

        for(int step=0; step<8; step++)
        {
            if(step == stepToIgnore) continue;
            switch (step)
            {
                case 1 : builder.name(VALID_NAME); break;
                case 2 : builder.accountAgency(VALID_AGENCY); break;
                case 3 : builder.accountNumber(VALID_ACCOUNT_NUMBER); break;
                case 4 : builder.accountBalance(VALID_ACCOUNT_BALANCE); break;
                case 5 : builder.accountCreditLimit(VALID_ACCOUNT_CREDIT_LIMIT); break;
                case 6 : builder.cardNumber(VALID_CARD_NUMBER); break;
                case 7 : builder.cardLimit(VALID_CARD_LIMIT); break;
                default: break;
            }
        }

        Set<ConstraintViolation<UserDto>> violations = validator.validate(builder.build());
        assertFalse(violations.isEmpty());
    }
}

/*
    private enum Step {ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN}

    @Test
    public void shouldFailWithInsufficientBuildSteps()
    {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        for(Step step : Step.values()) {
            Set<ConstraintViolation<UserDto>> violations = validator.validate(buildDto(step));
            if ((step == Step.ZERO)) {
                assertTrue(violations.isEmpty());
            } else {
                assertFalse(violations.isEmpty());
            }
        }
    }

    private UserDto buildDto(Step stepToIgnore)
    {
        UserDtoBuilder builder = new UserDtoBuilder();

        for(Step step : Step.values())
        {
            if(step == stepToIgnore) continue;
            switch (step)
            {
                case ONE  : builder.name(VALID_NAME); break;
                case TWO  : builder.accountAgency(VALID_AGENCY); break;
                case THREE: builder.accountNumber(VALID_ACCOUNT_NUMBER); break;
                case FOUR : builder.accountBalance(VALID_ACCOUNT_BALANCE); break;
                case FIVE : builder.accountCreditLimit(VALID_ACCOUNT_CREDIT_LIMIT); break;
                case SIX  : builder.cardNumber(VALID_CARD_NUMBER); break;
                case SEVEN: builder.cardLimit(VALID_CARD_LIMIT); break;
                default: break;
            }
        }
        return builder.build();
    }
*/