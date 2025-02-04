package springBoot_springSecurity.springSecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import springBoot_springSecurity.springSecurity.domain.dto.CreateAccessTokenRequest;
import springBoot_springSecurity.springSecurity.domain.dto.CreateAccessTokenResponse;
import springBoot_springSecurity.springSecurity.service.TokenService;

@RequiredArgsConstructor
@Controller
public class TokenApiController {

    private final TokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<CreateAccessTokenResponse> createNewAccessToken(
            @RequestBody CreateAccessTokenRequest request) {

        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateAccessTokenResponse(newAccessToken));
    }
}
