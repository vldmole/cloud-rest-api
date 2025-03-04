package learning.java.bankApp.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import learning.java.bankApp.domain.model.User;
import learning.java.bankApp.dto.UserDto;
import learning.java.bankApp.dto.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceDtoAdapterTest {

    @Autowired
    UserServiceDtoAdapter userServiceDtoAdapter;
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    UserDto setUpValidUserDto() {
        return new UserDto("Paulo Silva",
                "1234",
                "1234567890",
                new BigDecimal("10.00"),
                new BigDecimal("15.00"),
                "9876543210",
                new BigDecimal("200.00")
        );
    }

    @Test
    void shouldCreateUserFromUserDtoReturningUserDto() {

        UserDto given, expected, obtained;
        expected = given = setUpValidUserDto();
        obtained = userServiceDtoAdapter.create(given);

        assertNotNull(obtained);
        assertEquals(expected, obtained);
    }

    private UserDto setUpInvalidUserDto() {
        return new UserDto(" ",
                "1234",
                "1234567890",
                new BigDecimal(10.00),
                new BigDecimal(-15.00),
                "9876543210",
                new BigDecimal(-200.00)
        );
    }

    @Test
    void shouldThrowsWithInvalidUserDto(){

        UserDto given = setUpInvalidUserDto();
        assertThrows(ValidationException.class, () -> userServiceDtoAdapter.create(given));
    }

    @Test
    void shouldFindTheUserAndReturnUserDto(){

        User user = assertDoesNotThrow(()->userService.create(userMapper.toUser(setUpValidUserDto())));
        assertNotNull(user);

        UserDto dto = userServiceDtoAdapter.findById(user.getId());
        assertNotNull(dto);
        assertEquals(userMapper.toDto(user), dto);

        assertDoesNotThrow(()->userService.delete(user.getId()));
    }
}