//package springBoot_springSecurity.springSecurity.controller;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Slf4j
//@Controller
//public class LoginController {
//
//    @GetMapping("/login")
//    public String loginForm(@ModelAttribute("loginForm") LoginForm loginForm ) {
//        return "login/loginForm";
//    }
//
//    @PostMapping("/loginAction")
//    public String loginAction(@ModelAttribute("loginForm") LoginForm loginForm) {
//        log.info("loginForm: {}", loginForm);
//
//        return "redirect:/login";
//    }
//
//    // 로그인 form 에서 클라이언트에게 받을 정보
//    @Data
//    @AllArgsConstructor
//    static class LoginForm {
//        private String loginId;
//        private String password;
//    }
//}
