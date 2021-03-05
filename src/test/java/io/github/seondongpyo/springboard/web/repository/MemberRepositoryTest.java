package io.github.seondongpyo.springboard.web.repository;

import io.github.seondongpyo.springboard.web.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("Save a new Member")
    void saveMember() {
        Member member = new Member("test@gmail.com", "1234");
        Member savedMember = memberRepository.save(member);

        Member foundMember = memberRepository.findById(savedMember.getId())
                .orElseThrow(() -> new IllegalArgumentException("No member found (id = " + savedMember.getId() + ")"));

        assertThat(member.getId()).isEqualTo(foundMember.getId());
        assertThat(member.getEmail()).isEqualTo(foundMember.getEmail());
        assertThat(member.getPassword()).isEqualTo(foundMember.getPassword());
    }

}