package io.github.seondongpyo.springboard.web.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ViewControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("GET '/' Request")
    void home() {
        String body = testRestTemplate.getForObject("/", String.class);

        assertThat(body).contains("This is a Spring Board Project");
    }

    @Test
    @DisplayName("GET '/posts' Request")
    void posts() {
        String body = testRestTemplate.getForObject("/posts", String.class);

        assertThat(body).contains("게시물 목록");
    }

    @Test
    @DisplayName("GET '/posts/save' Request")
    void posts_save() {
        String body = testRestTemplate.getForObject("/posts/save", String.class);

        assertThat(body).contains("게시물 작성");
    }
}