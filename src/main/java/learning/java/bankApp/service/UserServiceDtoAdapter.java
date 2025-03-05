package learning.java.bankApp.service;


import jakarta.validation.Valid;
import learning.java.bankApp.domain.model.User;
import learning.java.bankApp.dto.UserDto;
import learning.java.bankApp.dto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class UserServiceDtoAdapter {

    private final UserService userService;
    private final UserMapper userMapper;
   // private final Validator validator;

    @Autowired
    public UserServiceDtoAdapter(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    public UserDto findById(long id) {
        return userMapper.toDto(userService.findById(id));
    }


    public UserDto create(@Valid UserDto userDto) {

      //  Set<ConstraintViolation<UserDto>> violations =validator.validate(userDto);
     //   if( violations.size() > 0 ){
      //    throw new ValidationException(violations.toString());
     //   }
        User userData = userMapper.toUser(userDto);
        User user = userService.create(userData);
        return userMapper.toDto(user);
    }

    public void delete(Long id)
    {
        userService.delete(id);
    }

    public List<UserDto> findAll(){
        return userService.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
