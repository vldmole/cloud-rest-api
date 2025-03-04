package learning.java.bankApp.facade;

import learning.java.bankApp.dto.UserDto;
import learning.java.bankApp.dto.UserMapper;
import learning.java.bankApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAppFacade
{
    private final UserService userService;

    @Autowired
    public BankAppFacade(UserService userService) {
        this.userService = userService;
    }

    public UserDto findUser(Long id) {

        UserMapper mapper = new UserMapper();
        return mapper.toDto(userService.findById(id));
    }
/*
    public List<UserDto> findAll() {
        UserMapper mapper = new UserMapper();
        return userService.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }*/
}
