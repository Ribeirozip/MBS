<<<<<<< HEAD
package com.br.blogging.post;

import com.br.blogging.user.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Long idPost;
    @Column(nullable = false)
    private String title;
    @Column
    private String image;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userId;

    public String getTitle(String title) throws Exception{
        if (title.length() > 50){
            throw new Exception("O campo title deve conter no máximo 100 caracteres");
        }
        this.title = title;
        return title;
    }
}
=======
package com.br.blogging.post;

import com.br.blogging.user.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "post")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Long idPost;
    @Column(nullable = false)
    private String title;
    @Column
    private String image;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userId;

    public String getTitle(String title) throws Exception{
        if (title.length() > 50){
            throw new Exception("O campo title deve conter no máximo 100 caracteres");
        }
        this.title = title;
        return title;
    }

    public PostModel(PostDTO postDTO){
        this.title = postDTO.getTitle();
        this.image = postDTO.getImage();
        this.content = postDTO.getContent();
    }
}
>>>>>>> f6bfd27cb4ca22ec95443948f46ad1c12f6fc5f9
