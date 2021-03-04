package io.github.seondongpyo.springboard.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {

    private Long id;
    private String title;
    private String content;

}
