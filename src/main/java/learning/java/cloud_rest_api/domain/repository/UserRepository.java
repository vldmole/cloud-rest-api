package learning.java.cloud_rest_api.domain.repository;

import learning.java.cloud_rest_api.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //nothing for while
}
