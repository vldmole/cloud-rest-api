package learning.java.bankApp.service.impl;

import learning.java.bankApp.domain.model.User;
import learning.java.bankApp.domain.repository.UserRepository;
import learning.java.bankApp.exception.ApplicationException;
import learning.java.bankApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .orElseThrow(() -> new ApplicationException("User not found id: "+id));
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
