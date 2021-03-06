package io.github.seondongpyo.springboard.web.controller;

import io.github.seondongpyo.springboard.web.dto.MemberSaveRequestDto;
import io.github.seondongpyo.springboard.web.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/save")
    public String savePage() {
        return "/members/save";
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody MemberSaveRequestDto dto) {
        memberService.save(dto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
