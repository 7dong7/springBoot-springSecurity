package springBoot_springSecurity.springSecurity.domain.dto.user;

import lombok.Data;

@Data
public class AddUserRequest {

    private String email;
    private String password;
}
