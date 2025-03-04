package learning.java.bankApp.service.impl;

import learning.java.bankApp.domain.model.User;
import learning.java.bankApp.domain.repository.UserRepository;
import learning.java.bankApp.service.UserService;
import learning.java.bankApp.service.exception.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    @Override
    public void delete(Long id) {

        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /*@Override
    public List<User> findAll() {
        return userRepository.findAll();
    }*/
}
