package io.github.seondongpyo.springboard.web.repository;

import io.github.seondongpyo.springboard.web.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
