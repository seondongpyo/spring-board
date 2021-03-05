package io.github.seondongpyo.springboard.web.service;

import io.github.seondongpyo.springboard.web.dto.MemberSaveRequestDto;
import io.github.seondongpyo.springboard.web.entity.Member;
import io.github.seondongpyo.springboard.web.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void save(MemberSaveRequestDto dto) {
        Member member = new Member(dto.getEmail(), dto.getPassword());
        memberRepository.save(member);
    }
}
