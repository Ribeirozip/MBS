<<<<<<< HEAD
package com.br.blogging.post;

public record PostDTO(Long id_post, String title, String image, String content) {
}
=======
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
>>>>>>> f6bfd27cb4ca22ec95443948f46ad1c12f6fc5f9
