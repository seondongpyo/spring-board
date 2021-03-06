package io.github.seondongpyo.springboard.web.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String email;
    private String password;

    public Member(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
