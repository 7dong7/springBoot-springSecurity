package springBoot_springSecurity.springSecurity.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MemberController {

    @GetMapping("/join")
    public String joinPage(@ModelAttribute("memberForm") MemberForm memberForm) {
        return "join";
    }

    @PostMapping("/joinAction")
    public String joinAction(@ModelAttribute("memberForm") MemberForm memberForm) {
        log.info("memberForm: {}", memberForm);
        return "board/board";
    }

    @Data
    @AllArgsConstructor
    static class MemberForm {
        private String name;
        private String username;
        private String password;
    }
}
