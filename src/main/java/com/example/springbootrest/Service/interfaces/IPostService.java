package com.example.springbootrest.Service.interfaces;

import com.example.springbootrest.entity.Post;

import java.util.List;

public interface IPostService {
    List<Post> getPostsList();
}
