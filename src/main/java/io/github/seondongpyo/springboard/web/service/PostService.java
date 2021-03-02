package io.github.seondongpyo.springboard.web.service;

import io.github.seondongpyo.springboard.web.dto.PostResponseDto;
import io.github.seondongpyo.springboard.web.entity.Post;
import io.github.seondongpyo.springboard.web.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public PostResponseDto findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Cannot find a post (id : " + id + ")");
                });

        return new PostResponseDto(post);
    }
}