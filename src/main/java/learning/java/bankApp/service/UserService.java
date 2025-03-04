package learning.java.bankApp.service;

import learning.java.bankApp.domain.model.User;

import java.util.List;


public interface UserService
{
    User findById(Long id);
    User create(User user);
    void delete(Long id);
    List<User> findAll();
}
