package io.github.seondongpyo.springboard.web.service;

import io.github.seondongpyo.springboard.web.dto.PostResponseDto;
import io.github.seondongpyo.springboard.web.dto.PostSaveRequestDto;
import io.github.seondongpyo.springboard.web.dto.PostUpdateRequestDto;
import io.github.seondongpyo.springboard.web.entity.Post;
import io.github.seondongpyo.springboard.web.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostResponseDto findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find a post (id : " + id + ")"));

        return new PostResponseDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> findAll() {
        return postRepository.findAll()
                .stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    public Long save(PostSaveRequestDto dto) {
        Post post = new Post(dto.getTitle(), dto.getContent(), dto.getWriter());

        return postRepository.save(post).getId();
    }

    public Long update(Long id, PostUpdateRequestDto dto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find a post (id : " + id + ")"));

        post.update(dto.getTitle(), dto.getContent());

        return id;
    }

    public Long delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find a post (id : " + id + ")"));

        postRepository.delete(post);

        return id;
    }
}
