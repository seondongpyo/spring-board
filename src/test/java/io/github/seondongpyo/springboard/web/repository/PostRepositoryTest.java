package io.github.seondongpyo.springboard.web.repository;

import io.github.seondongpyo.springboard.web.entity.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("Save a new post")
    void savePost() {
        Post post = new Post("제목1", "내용1", "홍길동");
        Post savedPost = postRepository.save(post);

        Optional<Post> foundPost = postRepository.findById(savedPost.getId());

        assertThat(foundPost.isPresent()).isTrue();
        assertThat(foundPost.get().getTitle()).isEqualTo(savedPost.getTitle());
        assertThat(foundPost.get().getContent()).isEqualTo(savedPost.getContent());
        assertThat(foundPost.get().getWriter()).isEqualTo(savedPost.getWriter());
    }
}