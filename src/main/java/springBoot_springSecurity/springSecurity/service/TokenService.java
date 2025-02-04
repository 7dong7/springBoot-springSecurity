package springBoot_springSecurity.springSecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springBoot_springSecurity.springSecurity.config.jwt.TokenProvider;
import springBoot_springSecurity.springSecurity.domain.entity.User;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) {
        // 토큰 유효성 검사에 실패하면 예외 발생
        if (!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("토큰 유효성 검사 실패");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
