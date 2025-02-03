package springBoot_springSecurity.springSecurity.util;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import springBoot_springSecurity.springSecurity.domain.entity.Member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final Member member;

    // 인증자 저장 로직
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getRole();
            }
        });
        return collection;
    }

    // password 호출
    @Override
    public String getPassword() {
        return member.getPassword();
    }

    // 사용자 id 호출
    @Override
    public String getUsername() {
        return member.getUsername();
    }
}
