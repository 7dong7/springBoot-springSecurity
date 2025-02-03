package springBoot_springSecurity.springSecurity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserViewController {

    @GetMapping("/login")
    public String login() {
        return "basic/login";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "basic/signup";
    }
}
