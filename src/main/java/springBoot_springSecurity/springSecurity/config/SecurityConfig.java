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
    // 접근 허용 리스트
    private static final String[] ALLOW_LIST = {"/", "/index", "/board", "/login"};

    // 보안 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(ALLOW_LIST).permitAll()
                        .requestMatchers(SOURCE_LIST).permitAll()
                );  // HTTP 요청에 대한 접근 권한 설정    // 이 메소드를 사용하면 각 URL 패턴에 대해 어떤 사용자나 역할이 접근할 수 있는지 정의



        return http.build();
    }
}
