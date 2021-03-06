package io.github.seondongpyo.springboard.web.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String title;
    private String content;
    private String writer;

    public Post(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
