package com.example.academiaapi.config;

import com.example.academiaapi.entity.UserEntity;
import com.example.academiaapi.repository.UserRepository;

import com.example.academiaapi.service.exceptions.UnauthorizeException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserEntity authenticated(){
       try{
           String username = SecurityContextHolder.getContext().getAuthentication().getName();
           return userRepository.findByEmail(username);
       }catch (Exception e){
           throw new UnauthorizeException("Usuario Invalido");
       }
    }

    public void validateSelfOrAdmin(Long id){
        UserEntity user = authenticated();
        if(!user.getId().equals(id) && !user.hasRole("ROLE_ADMIN")  ){
            throw new UnauthorizeException("Usuario não autorizado");
        }
    }

    public void validateAdmin(){
        UserEntity user = authenticated();
        if(!user.hasRole("ROLE_ADMIN")  ){
            throw new UnauthorizeException("Usuario não é administrador");
        }
    }
}
