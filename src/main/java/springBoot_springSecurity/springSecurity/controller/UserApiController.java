package springBoot_springSecurity.springSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springBoot_springSecurity.springSecurity.domain.dto.user.AddUserRequest;
import springBoot_springSecurity.springSecurity.service.UserService;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public String signUp(@ModelAttribute AddUserRequest request) {
        userService.save(request); // 회원 가입 서비스 메소드 호출
        return "redirect:/login"; // 회원 가입이 완료된 이후에 로그인 페이지로 이동
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        new SecurityContextLogoutHandler()
                .logout(request,
                        response,
                        SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}
