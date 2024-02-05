package com.br.blogging.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UserLoginDTO {
    private String username;
    private String password;

    public UserLoginDTO(){
    }

    public UserLoginDTO(UserModel user){
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

}
