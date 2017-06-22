package loafer.repository;

import loafer.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wuyuexin on 2017/5/17.
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String>{
}
