package learning.java.bankApp.facade;

import learning.java.bankApp.dto.UserDto;
import learning.java.bankApp.service.UserServiceDtoAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAppFacade
{
    private final UserServiceDtoAdapter userService;

    @Autowired
    public BankAppFacade(UserServiceDtoAdapter userService) {
        this.userService = userService;
    }

    public UserDto createUser(UserDto userDto){
        return userService.create(userDto);
    }

    public UserDto findUser(Long id) {
        return userService.findById(id);
    }

    public List<UserDto> findAll() {
        return userService.findAll();
    }

    public void deleteUser(Long id) {
        userService.delete(id);
    }
}
