package springBoot_springSecurity.springSecurity.domain.member;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JoinMemberForm {
    private String name;
    private String username;
    private String password;
}
