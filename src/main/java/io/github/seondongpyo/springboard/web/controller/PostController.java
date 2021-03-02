package io.github.seondongpyo.springboard.web.controller;

import io.github.seondongpyo.springboard.web.dto.PostResponseDto;
import io.github.seondongpyo.springboard.web.dto.PostSaveRequestDto;
import io.github.seondongpyo.springboard.web.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("")
    public String findAll(Model model) {
        List<PostResponseDto> posts = postService.findAll();
        model.addAttribute("posts", posts);

        return "/posts/list";
    }

    @GetMapping("/save")
    public String savePage() {
        return "/posts/save";
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody PostSaveRequestDto dto) {
        postService.save(dto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}