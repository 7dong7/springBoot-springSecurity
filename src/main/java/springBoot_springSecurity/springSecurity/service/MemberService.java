package springBoot_springSecurity.springSecurity.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springBoot_springSecurity.springSecurity.domain.member.JoinMemberForm;
import springBoot_springSecurity.springSecurity.domain.entity.Member;
import springBoot_springSecurity.springSecurity.repository.member.MemberRepository;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberRepository memberRepository;

    // Member 회원가입
    @Transactional
    public void saveMember(JoinMemberForm joinMemberForm) {
        String encodedPassword = bCryptPasswordEncoder.encode(joinMemberForm.getPassword());
        log.info("encodedPassword: {}", encodedPassword);
        // $2a$10$jME1Fd3fJkTeVT0nFYDra.M6hxv.jnHt4SYTBy26ThB6oSXJHYLYG

        Member joinMember = Member.builder()
                .name(joinMemberForm.getName())
                .username(joinMemberForm.getUsername())
                .password(encodedPassword)
                .build();

        memberRepository.save(joinMember);
    }

}
