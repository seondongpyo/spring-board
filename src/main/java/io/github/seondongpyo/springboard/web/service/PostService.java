package io.github.seondongpyo.springboard.web.service;

import io.github.seondongpyo.springboard.web.dto.PostResponseDto;
import io.github.seondongpyo.springboard.web.dto.PostSaveRequestDto;
import io.github.seondongpyo.springboard.web.entity.Post;
import io.github.seondongpyo.springboard.web.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostResponseDto findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("Cannot find a post (id : " + id + ")");
                });

        return new PostResponseDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> findAll() {
        return postRepository.findAll()
                .stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    public void save(PostSaveRequestDto dto) {
        Post post = new Post(dto.getTitle(), dto.getContent(), dto.getWriter());
        postRepository.save(post);
    }
}
