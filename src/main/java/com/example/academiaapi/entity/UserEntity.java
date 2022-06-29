package com.example.academiaapi.entity;

import com.example.academiaapi.enums.MetodoDeTreino;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nome;
    private String dataDeNascimento;
    private String telefone;
    @Email
    private String email;
    @NotEmpty
    private String senha;
    private MetodoDeTreino metodoDeTreino;

    @ManyToMany(mappedBy = "user" )
    private List<TreinoPagoEntity> diasTreinados;

}
