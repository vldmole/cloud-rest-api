package learning.java.bankApp.dto;

import learning.java.bankApp.domain.model.Account;
import learning.java.bankApp.domain.model.Card;
import learning.java.bankApp.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    UserMapper userMapper = new UserMapper();
    User user = null;
    UserDto userDto = null;

    @BeforeEach
    void setUpUser() {
        user = new User();
        user.setName("John Smith");

        Account account = new Account();
        account.setAgency("123");
        account.setNumber("1234567890");
        account.setBalance(new BigDecimal("10.50"));
        account.setCreditLimit(new BigDecimal("15.00"));
        user.setAccount(account);

        Card card = new Card();
        card.setNumber("9876543210");
        card.setCreditLimit(new BigDecimal("150.00"));
        user.setCard(card);
    }

    @BeforeEach
    void setUpUserDto() {
        userDto = new UserDto(
                null,
                "Paulo Silva",
                "1234",
                "1234567890",
                new BigDecimal("10.00"),
                new BigDecimal("15.00"),
                "9876543210",
                new BigDecimal("150.00")
        );
    }

    @Test
    public void shouldConvertUserIntoUserDto() {

        UserDto userDto = userMapper.toDto(user);

        assertNotNull(userDto);
        assertEquals(userDto.name(), user.getName());
        assertEquals(userDto.accountAgency(),user.getAccount().getAgency());
        assertEquals(userDto.accountNumber(),user.getAccount().getNumber());
        assertEquals(userDto.accountBalance(),user.getAccount().getBalance());
        assertEquals(userDto.accountCreditLimit(),user.getAccount().getCreditLimit());
        assertEquals(userDto.cardNumber(),user.getCard().getNumber());
        assertEquals(userDto.cardLimit(),user.getCard().getCreditLimit());

    }

    @Test
    public void shouldConvertUserDtoIntoUser() {

        User user = userMapper.toUser(userDto);

        assertNotNull(user);
        assertEquals(user.getName(),userDto.name());
        assertEquals(user.getAccount().getAgency(),userDto.accountAgency());
        assertEquals(user.getAccount().getNumber(),userDto.accountNumber());
        assertEquals(user.getAccount().getBalance(),userDto.accountBalance());
        assertEquals(user.getAccount().getCreditLimit(),userDto.accountCreditLimit());
        assertEquals(user.getCard().getNumber(),userDto.cardNumber());
        assertEquals(user.getCard().getCreditLimit(),userDto.cardLimit());
    }
}