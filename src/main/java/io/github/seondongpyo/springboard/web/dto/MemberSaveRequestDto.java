package io.github.seondongpyo.springboard.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {

    private String email;
    private String password;
}
