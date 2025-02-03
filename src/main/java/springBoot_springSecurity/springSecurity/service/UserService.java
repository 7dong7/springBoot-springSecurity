package springBoot_springSecurity.springSecurity.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import springBoot_springSecurity.springSecurity.domain.dto.user.AddUserRequest;
import springBoot_springSecurity.springSecurity.domain.entity.User;
import springBoot_springSecurity.springSecurity.repository.user.UserRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(
                User.builder()
                        .email(dto.getEmail())
                        // 패스워드 암호화
                        .password(bCryptPasswordEncoder.encode(dto.getPassword()))
                        .build()).getId();
    }

}
