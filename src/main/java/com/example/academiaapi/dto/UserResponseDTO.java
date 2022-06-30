package com.example.academiaapi.dto;

import com.example.academiaapi.entity.*;
import com.example.academiaapi.enums.MetodoDeTreino;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    private Long id;
    private String nome;
    private String dataDeNascimento;
    private String telefone;
    private String email;

    private MetodoDeTreino metodoDeTreino;

    private Set<TreinoPagoEntity> diasTreinados;
    private Set<FichaEntity> fichaDeTreino;



    public UserResponseDTO(UserEntity userEntity){
        this.id = userEntity.getId();
        this.nome = userEntity.getNome();
        this.dataDeNascimento = userEntity.getDataDeNascimento();
        this.telefone = userEntity.getTelefone();
        this.email = userEntity.getEmail();
        this.diasTreinados = userEntity.getTreinosPago();
        this.fichaDeTreino = userEntity.getFichas();



    }


}
