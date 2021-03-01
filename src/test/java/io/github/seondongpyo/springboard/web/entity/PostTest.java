package io.github.seondongpyo.springboard.web.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostTest {

    @Test
    @DisplayName("Post entity test")
    void postEntity() {
        Post post = new Post("제목", "내용", "홍길동");

        assertThat(post.getTitle()).isEqualTo("제목");
        assertThat(post.getContent()).isEqualTo("내용");
        assertThat(post.getWriter()).isEqualTo("홍길동");
    }

}