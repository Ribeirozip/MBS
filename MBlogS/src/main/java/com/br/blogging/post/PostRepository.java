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
