package springBoot_springSecurity.springSecurity.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username; // 사용자 id
    private String password; // 사용자 비밀번호
    private String name; // 사용자 이름, 닉네임

    @Builder
    public Member(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
