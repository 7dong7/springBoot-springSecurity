package springBoot_springSecurity.springSecurity.domain.dto;

import lombok.Data;

@Data
public class CreateAccessTokenRequest {
    private String refreshToken;
}
