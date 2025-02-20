package learning.java.cloud_rest_api.service.impl;

import learning.java.cloud_rest_api.domain.model.User;
import learning.java.cloud_rest_api.domain.repository.UserRepository;
import learning.java.cloud_rest_api.service.UserService;
import learning.java.cloud_rest_api.service.exception.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id)
    {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserServiceException("User not found i:"+id));
    }

    @Override
    public User create(User user)
    {
        //validation step
        return userRepository.save(user);
    }
}
