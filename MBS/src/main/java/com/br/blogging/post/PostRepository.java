<<<<<<< HEAD
package com.br.blogging.post;

import com.br.blogging.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostModel, Long> {
//    List<PostModel> findByUser(UserModel userId);
// Encontrar todos os posts de um usuário específico usando JPQL
    @Query("SELECT p FROM PostModel p WHERE p.userId = :userId")
    List<PostModel> findPostsByUser(@Param("userId") UserModel userId);
}
=======
package com.br.blogging.post;

import com.br.blogging.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<PostModel, Long> {

// Encontrar todos os posts de um usuário específico usando JPQL
    @Query("SELECT p FROM PostModel p WHERE p.userId = :userId")
    List<PostModel> findPostsByUser(@Param("userId") UserModel userId);
}
>>>>>>> f6bfd27cb4ca22ec95443948f46ad1c12f6fc5f9
