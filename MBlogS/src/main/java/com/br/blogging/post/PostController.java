package com.br.blogging.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/Inicio")
@CrossOrigin("*")
public class PostController {
    @Autowired(required = true)
    public PostRepository postRepository;

    @Autowired
    public PostService postService;


    @PostMapping("/novoPost")
    public ResponseEntity<String> newPost(@RequestBody PostModel post){
        if(post ==null|| post.getTitle() == null || post.getContent() ==null || post.getUserId() == null){
            return ResponseEntity.badRequest().body("Titulo, conteudo e ID do usuário são obirgatórios");
        }
        if(postService.isPostContentValid(post.getContent())){
        postRepository.save(post);
        return ResponseEntity.ok("Novo post feito" + post);
        }else {
            return ResponseEntity.badRequest().body("Conteudo do post contem palavras ofensivas.");
        }
    }

    @GetMapping
    public ResponseEntity getAllPost(){
        var allposts = postRepository.findAll();
        return ResponseEntity.ok(allposts);
    }

    @PutMapping("/{idPost}")
    public ResponseEntity<String> updatePost(@PathVariable Long idPost, @RequestBody PostDTO updatePostDTO) {
        if (updatePostDTO == null || updatePostDTO.getIdPost() == null ||  updatePostDTO.getTitle() == null || updatePostDTO.getContent() ==null ){
            return ResponseEntity.badRequest().body("Os atributos do post são necessário para o update.");
        }
        Optional<PostModel> existingPost = postRepository.findById(updatePostDTO.getIdPost());

        if (existingPost.isPresent()) {
            PostModel postToUpdate = postService.updateDTO(idPost, updatePostDTO);
            return ResponseEntity.ok("Post atualizado com sucesso." + postToUpdate);
        } else {
            return new ResponseEntity<>("Post não encontrado. Atualização falhou.", HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{idPost}")
    public ResponseEntity<String> deletePost(@PathVariable Long idPost) {
        if (idPost == null) {
            return ResponseEntity.badRequest().body("O ID do post é necessário para o delete");
        }
        System.out.println("Tentativa de excluir post com ID: " + idPost);

        Optional<PostModel> existingPost = postRepository.findById(idPost);
        if (existingPost.isPresent()) {
            postRepository.deleteById(idPost);
            return ResponseEntity.ok("Post excluído com sucesso.");
        } else {
            return new ResponseEntity<>("Post não encontrado. Excluir falhou.", HttpStatus.NOT_FOUND);
        }
    }

}
