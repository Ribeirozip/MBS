<<<<<<< HEAD
package com.br.blogging.user;

import com.br.blogging.post.PostModel;
import com.br.blogging.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/perfil")
public class UserController {

    @Autowired(required = true)
    public UserRepository userRepository;

    @Autowired(required = true)
    public PostRepository postRepository;

    @PostMapping
    public ResponseEntity newUser(@RequestBody UserModel user){
        if (userRepository.existsByUsername(user.getUsername())){
            return ResponseEntity.badRequest().body("Nome de usuário já existe. Escolha um nome de usuário diferente.");
        }
        if (user == null || user.getUsername() == null || user.getUsername() == null || user.getPassword() == null){
            return  ResponseEntity.badRequest().body("user, nome e senha são obrigatórios.");
        }

        var userCreated = this.userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("User criado com sucesso!\n" + userCreated);
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        var allusers = userRepository.findAll();
        return ResponseEntity.ok(allusers);
    }

    @GetMapping("/{idUser}/posts")
    public ResponseEntity<List<PostModel>> getUserPosts(@PathVariable Long idUser){
        Optional<UserModel> userOptional = userRepository.findById(idUser);

        if (userOptional.isPresent()){
            UserModel user = userOptional.get();
            List<PostModel> userPosts = postRepository.findPostsByUser(user);
            return ResponseEntity.ok(userPosts);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserModel loginUser){
        UserModel user = userRepository.findByUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword());

        if (user != null){
            return ResponseEntity.ok("Login bem-sucedido. ID do usuário: " + user.getIdUser());
        } else {
            return ResponseEntity.badRequest().body("Usuário ou senha inválido.");
        }
    }

    @PutMapping("/")
    public ResponseEntity<String> updateUser(@RequestBody UserModel user){
        if (user.getIdUser() == null){
            return ResponseEntity.badRequest().body("O ID é necessário para o update.");
        }
        Optional<UserModel> existingUser = userRepository.findById(user.getIdUser());

        if (existingUser.isPresent()){
            var userToUpdate = this.userRepository.save(user);
            return ResponseEntity.ok("User atualizado com sucesso.");
        } else {
            return new ResponseEntity<>("User não encontrado. Atualização falhou.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<String> deleteUser(@PathVariable Long idUser){
        if (idUser == null){
            return ResponseEntity.badRequest().body("O ID do user é necessário para o delete");
        }
        System.out.println("Tentativa de excluir user com ID: " + idUser);

        Optional<UserModel> existingUser = userRepository.findById(idUser);
        if(existingUser.isPresent()){
            userRepository.deleteById(idUser);
            return ResponseEntity.ok("User excluído com sucesso.");
        } else {
            return new ResponseEntity<>("User não encontrado. Excluir falhou.", HttpStatus.NOT_FOUND);
        }
    }



}
=======
package com.br.blogging.user;

import com.br.blogging.post.PostModel;
import com.br.blogging.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/perfil")
@CrossOrigin("*")
public class UserController {

    @Autowired(required = true)
    public UserRepository userRepository;

    @Autowired(required = true)
    public PostRepository postRepository;

    @PostMapping("/cadastro")
    public ResponseEntity newUser(@RequestBody UserModel user){
        if (userRepository.existsByUsername(user.getUsername())){
            return ResponseEntity.badRequest().body("Nome de usuário já existe. Escolha um nome de usuário diferente.");
        }
        var userCreated = this.userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("User criado com sucesso!\n" + userCreated);
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        var allusers = userRepository.findAll();
        return ResponseEntity.ok(allusers);
    }

    @GetMapping("/{idUser}/posts")
    public ResponseEntity<List<PostModel>> getUserPosts(@PathVariable Long idUser){
        Optional<UserModel> userOptional = userRepository.findById(idUser);

        if (userOptional.isPresent()){
            UserModel user = userOptional.get();
            List<PostModel> userPosts = postRepository.findPostsByUser(user);
            return ResponseEntity.ok(userPosts);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO loginUser){
        UserModel user = userRepository.findByUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword());

        if (user != null){
            return ResponseEntity.ok("Login bem-sucedido. ID do usuário: " + user.getIdUser());
        } else {
            return ResponseEntity.badRequest().body("Usuário ou senha inválido.");
        }

    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserModel user){
        if (user.getIdUser() == null){
            return ResponseEntity.badRequest().body("O ID é necessário para o update.");
        }
        Optional<UserModel> existingUser = userRepository.findById(user.getIdUser());

        if (existingUser.isPresent()){
            var userToUpdate = this.userRepository.save(user);
            return ResponseEntity.ok("User atualizado com sucesso.");
        } else {
            return new ResponseEntity<>("User não encontrado. Atualização falhou.", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<String> deleteUser(@PathVariable Long idUser){
        if (idUser == null){
            return ResponseEntity.badRequest().body("O ID do user é necessário para o delete");
        }
        System.out.println("Tentativa de excluir user com ID: " + idUser);

        Optional<UserModel> existingUser = userRepository.findById(idUser);
        if(existingUser.isPresent()){
            userRepository.deleteById(idUser);
            return ResponseEntity.ok("User excluído com sucesso.");
        } else {
            return new ResponseEntity<>("User não encontrado. Excluir falhou.", HttpStatus.NOT_FOUND);
        }
    }



}
>>>>>>> f6bfd27cb4ca22ec95443948f46ad1c12f6fc5f9
