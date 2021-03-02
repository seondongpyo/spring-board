package io.github.seondongpyo.springboard.web.dto;

import io.github.seondongpyo.springboard.web.entity.Post;
import lombok.Data;

@Data
public class PostResponseDto {

    private Long id;
    private String title;
    private String content;
    private String writer;

    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
    }
}
