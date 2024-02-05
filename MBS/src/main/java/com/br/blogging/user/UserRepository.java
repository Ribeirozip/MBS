<<<<<<< HEAD
package com.br.blogging.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);

    UserModel findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);
}
=======
package com.br.blogging.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);

    UserModel findByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);
}
>>>>>>> f6bfd27cb4ca22ec95443948f46ad1c12f6fc5f9
