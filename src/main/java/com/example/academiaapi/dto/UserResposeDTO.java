package com.example.academiaapi.dto;

import com.example.academiaapi.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResposeDTO {

    private Long id;
    private String nome;
    private String dataDeNascimento;
    private String telefone;
    private String email;


    public UserResposeDTO(UserEntity userEntity){
        this.id = userEntity.getId();
        this.nome = userEntity.getNome();
        this.dataDeNascimento = userEntity.getDataDeNascimento();
        this.telefone = userEntity.getTelefone();
        this.email = userEntity.getEmail();
    }


}
