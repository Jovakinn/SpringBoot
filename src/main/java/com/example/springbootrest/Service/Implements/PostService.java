package com.example.springbootrest.Service.Implements;

import com.example.springbootrest.DAO.PostRepository;
import com.example.springbootrest.Service.interfaces.IPostService;
import com.example.springbootrest.entity.Post;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService implements IPostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getPostsList(){
        return postRepository.findAll();
    }
}
