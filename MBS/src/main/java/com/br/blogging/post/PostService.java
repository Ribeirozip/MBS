package com.br.blogging.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public PostModel updateDTO(Long idPost, PostDTO postDTO){
        Optional<PostModel> existingPost = postRepository.findById(idPost);

        if (existingPost.isPresent()){
            PostModel post = existingPost.get();

            if (postDTO != null){
                post.setIdPost(postDTO.getIdPost());
                post.setTitle(postDTO.getTitle());
                post.setContent(postDTO.getContent());
                post.setImage(postDTO.getImage());
            } else {
                return null;
            }
            return postRepository.save(post);
        }
        return null;
    }
}
