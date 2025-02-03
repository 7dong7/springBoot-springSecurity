package springBoot_springSecurity.springSecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class IndexController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/board")
    public String board(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("username", username);
        return "board/board";
    }
}
