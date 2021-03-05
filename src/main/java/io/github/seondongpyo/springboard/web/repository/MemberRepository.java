package io.github.seondongpyo.springboard.web.repository;

import io.github.seondongpyo.springboard.web.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
