package springBoot_springSecurity.springSecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {
    // 소스 리스트
    private static final String[] SOURCE_LIST = {"/resource/**", "/css/**", "/js/**", "/img/**", "/fonts/**", "/*.ico"};
    // 접근 허용 리스트 (로그인 없이)
    private static final String[] ALLOW_LIST = {"/", "/index", "/board", "/login", "/loginAction", "/join", "/joinAction"};
    // 사용자 권한 접근 가능 리스트
    private static final String[] USER_LIST = {"/board", "/write"};
    // 관리자 권한 접근 가능 리스트
    private static final String[] ADMIN_LIST = {"/admin/**"};

    // 보안 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 접근 권한, 경로 설정
        http
                .authorizeHttpRequests(auth -> auth // HTTP 요청에 대한 접근 권한 설정
                        // 이 메소드를 사용하면 각 URL 패턴에 대해 어떤 사용자나 역할이 접근할 수 있는지 정의
                        .requestMatchers(ALLOW_LIST).permitAll() // ALLOW_LIST 에 작성된 경로 접근 모두 허용
                        .requestMatchers(SOURCE_LIST).permitAll() // SOURCE_LIST 에 작성된 경로 접근 모두 허용
                        .requestMatchers(USER_LIST).hasAnyRole("USER", "ADMIN") // USER_LIST 에 작성된 경로 "USER", "ADMIN" 역할 허용
                        .requestMatchers(ADMIN_LIST).hasRole("ADMIN") // ADMIN_LIST 에 작성된 경로 ADMIN 사용자에게만 허용
                );

        // 폼 로그인 설정
        http
                .formLogin(login -> login
                        .loginPage("/login") // 내가 로그인 하기 위해서 접근하는 로그인 페이지 경로 (개발자가 만든 페이지)
                        .loginProcessingUrl("/loginAction") // 로그인 기능 구현된 url
                        .defaultSuccessUrl("/board") // 로그인 성공시 이동 경로 URL
                        .failureUrl("/error") // 로그인 실패시 경로
                        .usernameParameter("username") // 로그인 폼의 로그인ID 필드 명이 username 인 경우 생략가능
                        .passwordParameter("password") // 로그인 폼의 비밀번호 필드 명이 password 인 경우 생략 가능
                        .permitAll()
                );

        // CSRF; Cross-Site Request Forgery - 보호 기능 비활성화
        http
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    // 스프링 시큐리티에서 제공하는 비밀번호 암호화 도구
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // BCrypt 해시 함수를 사용
    }
    
}
