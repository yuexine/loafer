package loafer.repository;

import loafer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by w on 2017/5/2.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneWithAuthoritiesByUsername(String lowercaseUsername);
}
