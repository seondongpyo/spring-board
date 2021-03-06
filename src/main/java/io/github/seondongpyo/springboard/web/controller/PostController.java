package io.github.seondongpyo.springboard.web.controller;

import io.github.seondongpyo.springboard.web.dto.PostResponseDto;
import io.github.seondongpyo.springboard.web.dto.PostSaveRequestDto;
import io.github.seondongpyo.springboard.web.dto.PostUpdateRequestDto;
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

    @GetMapping
    public String findAll(Model model) {
        List<PostResponseDto> posts = postService.findAll();
        model.addAttribute("posts", posts);

        return "/posts/list";
    }

    @GetMapping("/save")
    public String savePage() {
        return "/posts/save";
    }

    @GetMapping("/{id}/update")
    public String editPage(@PathVariable Long id,
                           Model model) {
        PostResponseDto post = postService.findById(id);
        model.addAttribute("post", post);

        return "/posts/update";
    }

    @GetMapping("/{id}")
    public String detailPage(@PathVariable Long id,
                             Model model) {
        PostResponseDto post = postService.findById(id);
        model.addAttribute("post", post);

        return "/posts/detail";
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PostSaveRequestDto dto) {
        postService.save(dto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody PostUpdateRequestDto dto) {

        postService.update(id, dto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        postService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
