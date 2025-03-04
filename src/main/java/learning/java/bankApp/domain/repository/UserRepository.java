package learning.java.bankApp.domain.repository;

import learning.java.bankApp.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //nothing for while
}
