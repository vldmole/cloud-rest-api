package learning.java.cloud_rest_api.service;

import learning.java.cloud_rest_api.domain.model.User;
import org.springframework.stereotype.Service;

public interface UserService
{
    User findById(Long id);
    User create(User user);
}
