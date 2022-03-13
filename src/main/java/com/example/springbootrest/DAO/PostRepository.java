package com.example.springbootrest.DAO;

import com.example.springbootrest.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
