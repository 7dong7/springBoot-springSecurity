package springBoot_springSecurity.springSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springBoot_springSecurity.springSecurity.domain.jwt.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByUserId(Long userId);

    Optional<RefreshToken> findByRefreshToken(String refreshToken);

    void deleteByUserId(Long userId);
}
