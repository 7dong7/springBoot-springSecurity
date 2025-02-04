package springBoot_springSecurity.springSecurity.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateAccessTokenResponse {
    private String accessToken;
}
