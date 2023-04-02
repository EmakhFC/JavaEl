package com.elmakh.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.elmakh.blog.models.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
