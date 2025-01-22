package springBoot_springSecurity.springSecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // 소스 리스트
    private static final String[] SOURCE_LIST = {"/resource/**", "/css/**", "/js/**", "/img/**", "/fonts/**", "/*.ico"};
    // 접근 허용 리스트 (로그인 없이)
    private static final String[] ALLOW_LIST = {"/", "/index", "/board", "/login"};
    // 사용자 권한 접근 가능 리스트
    private static final String[] USER_LIST = {"/board", "/write"};
    // 관리자 권한 접근 가능 리스트
    private static final String[] ADMIN_LIST = {"/admin/**"};

    // 보안 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth // HTTP 요청에 대한 접근 권한 설정
                // 이 메소드를 사용하면 각 URL 패턴에 대해 어떤 사용자나 역할이 접근할 수 있는지 정의
                        .requestMatchers(ALLOW_LIST).permitAll() // ALLOW_LIST 에 작성된 경로 접근 모두 허용
                        .requestMatchers(SOURCE_LIST).permitAll() // SOURCE_LIST 에 작성된 경로 접근 모두 허용
                        .requestMatchers(USER_LIST).hasAnyRole("USER", "ADMIN") // USER_LIST 에 작성된 경로 "USER", "ADMIN" 역할 허용
                        .requestMatchers(ADMIN_LIST).hasRole("ADMIN") // ADMIN_LIST 에 작성된 경로 ADMIN 사용자에게만 허용
                );



        return http.build();
    }
}
