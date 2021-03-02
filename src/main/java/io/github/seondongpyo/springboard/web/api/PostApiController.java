package io.github.seondongpyo.springboard.web.api;

import io.github.seondongpyo.springboard.web.dto.PostResponseDto;
import io.github.seondongpyo.springboard.web.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostApiController {

    private final PostService postService;

    @GetMapping("/{id}")
    public PostResponseDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }
}
