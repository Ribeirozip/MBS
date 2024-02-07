package com.br.blogging.post;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PostDTO{
    private Long idPost;
    private String title;
    private String image;
    private String content;

    public PostDTO(){
    }

    public PostDTO(PostModel post){
        this.idPost = post.getIdPost();
        this.title = post.getTitle();
        this.image = post.getImage();
        this.content = post.getContent();
    }
}
