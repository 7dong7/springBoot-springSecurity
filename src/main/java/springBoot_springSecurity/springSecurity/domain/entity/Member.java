package springBoot_springSecurity.springSecurity.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username; // 사용자 id
    private String password; // 사용자 비밀번호
    private String name; // 사용자 이름, 닉네임

    public String role; // 규칙 // USER, ADMIN

    public Member(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
