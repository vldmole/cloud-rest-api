package learning.java.bankApp.service;

import jakarta.validation.ConstraintViolationException;
import learning.java.bankApp.domain.model.User;
import learning.java.bankApp.dto.UserDto;
import learning.java.bankApp.dto.UserMapper;
import learning.java.bankApp.service.exception.UserServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceDtoAdapterTest
{

    @Autowired
    UserServiceDtoAdapter userServiceDtoAdapter;
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    private void cleanUserModel()
    {
        List<User> users = userService.findAll();
        assertDoesNotThrow(()->users.forEach(u->userService.delete(u.getId())));
    }

    @Test
    void shouldCreateUserFromUserDto() {

        UserDto given, expected, obtained;
        expected = given = arrayOfUserDtos[0];
        obtained = userServiceDtoAdapter.create(given);

        assertNotNull(obtained);
        assertEquals(expected, obtained);

        cleanUserModel();
    }

    @Test
    void shouldDeleteUserById()
    {
        User user = userMapper.toUser(arrayOfUserDtos[0]);
        assertDoesNotThrow(()->userService.create(user));

        assertDoesNotThrow(()->userServiceDtoAdapter.delete(user.getId()));

        assertThrows(UserServiceException.class, ()->userService.findById(user.getId()));
    }

    @Test
    void shouldThrowsWithInvalidUserDto(){

        UserDto given = invalidUserDto;
        assertThrows(ConstraintViolationException.class, () -> userServiceDtoAdapter.create(given));
    }


    @Test
    void shouldFindTheUserAndReturnUserDto(){

        User user = assertDoesNotThrow(()->userService.create(userMapper.toUser(arrayOfUserDtos[0])));
        assertNotNull(user);

        UserDto dto = userServiceDtoAdapter.findById(user.getId());
        assertNotNull(dto);
        assertEquals(userMapper.toDto(user), dto);

        cleanUserModel();
    }

    @Test
    void shouldFindAllUserDtos()
    {
        for(UserDto dto: arrayOfUserDtos)
            assertDoesNotThrow(()->userServiceDtoAdapter.create(dto));

        List<UserDto> lstDtos = assertDoesNotThrow(()->userServiceDtoAdapter.findAll());
        assertNotNull(lstDtos);
        assertEquals(arrayOfUserDtos.length, lstDtos.size());
        for(UserDto dto: arrayOfUserDtos)
            assertTrue(lstDtos.stream().filter(item -> item.name().equals(dto.name())).findFirst().isPresent());

        cleanUserModel();
    }

    static UserDto[] arrayOfUserDtos = new UserDto[]{
            new UserDto(1l,"Paulo Silva", "123", "1234675890",new BigDecimal("15.00"),BigDecimal.valueOf(15000,2),"09876543",BigDecimal.valueOf(30_000,2)),
            new UserDto(2l, "Maria Pereira", "163", "1232347890",BigDecimal.valueOf(2500,2),BigDecimal.valueOf(25000,2),"09436543",BigDecimal.valueOf(10_000,2)),
            new UserDto(3l, "Clécio alvarenag", "553", "12987654890",BigDecimal.valueOf(2300,2),BigDecimal.valueOf(65000,2),"05712389",BigDecimal.valueOf(20_000,2))
    };

    static UserDto invalidUserDto = new UserDto(
                null,
                " ",
                "1234",
                "1234567890",
                new BigDecimal(10.00),
                new BigDecimal(-15.00),
                "9876543210",
                new BigDecimal(-200.00)
        );
}