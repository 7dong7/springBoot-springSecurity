package springBoot_springSecurity.springSecurity.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import springBoot_springSecurity.springSecurity.domain.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 이메일로 사용자 조회
    Optional<User> findByEmail(String Email);
}
