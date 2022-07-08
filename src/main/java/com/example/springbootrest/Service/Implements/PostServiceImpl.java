package com.example.springbootrest.Service.Implements;

import com.example.springbootrest.DAO.PostRepository;
import com.example.springbootrest.Service.interfaces.PostService;
import com.example.springbootrest.entity.Post;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getPostsList(){
        return postRepository.findAll();
    }
}
