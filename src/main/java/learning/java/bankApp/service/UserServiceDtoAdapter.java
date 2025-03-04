package learning.java.bankApp.service;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import learning.java.bankApp.domain.model.User;
import learning.java.bankApp.dto.UserDto;
import learning.java.bankApp.dto.UserDtoBuilder;
import learning.java.bankApp.dto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Set;

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


    UserDto findById(long id) {
        return userMapper.toDto(userService.findById(id));
    }


    UserDto create(@Valid UserDto userDto) {

      //  Set<ConstraintViolation<UserDto>> violations =validator.validate(userDto);
     //   if( violations.size() > 0 ){
      //    throw new ValidationException(violations.toString());
     //   }

        return userMapper.toDto(userService.create(userMapper.toUser(userDto)));
    }
}
