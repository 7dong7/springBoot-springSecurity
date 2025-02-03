package springBoot_springSecurity.springSecurity.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springBoot_springSecurity.springSecurity.domain.entity.Member;
import springBoot_springSecurity.springSecurity.repository.member.MemberRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> optMember = memberRepository.findByUsername(username);
        log.info("optMember empty: {}", optMember.isEmpty());
        log.info("optMember present: {}", optMember.isPresent());
        log.info("optMember: {}", optMember);

        Member member = optMember.get();
        log.info("member: {}", member);
        return null;
    }
}
