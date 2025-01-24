package springBoot_springSecurity.springSecurity.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springBoot_springSecurity.springSecurity.domain.member.JoinMemberForm;
import springBoot_springSecurity.springSecurity.service.MemberService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String joinPage(@ModelAttribute("memberForm") JoinMemberForm memberForm) {
        return "join";
    }

    @PostMapping("/joinAction")
    public String joinMember(@ModelAttribute("memberForm") JoinMemberForm memberForm) {
        log.info("memberForm: {}", memberForm);
        
        memberService.saveMember(memberForm);
        return "redirect:/login";
    }

}
