package com.example.academiaapi.controller;

import com.example.academiaapi.config.AuthService;
import com.example.academiaapi.dto.UserResponseDTO;
import com.example.academiaapi.entity.TreinoPagoEntity;
import com.example.academiaapi.entity.UserEntity;
import com.example.academiaapi.repository.TreinoPagoRepository;
import com.example.academiaapi.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final AuthService authService;



    private final UserRepository userRepository;

    private final TreinoPagoRepository treinoPagoRepository;

    public ClientController(AuthService authService, UserRepository userRepository, TreinoPagoRepository treinoPagoRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
        this.treinoPagoRepository = treinoPagoRepository;
    }


    @PostMapping("/pagartreino/{id}")
    public String pagarTreino(@PathVariable Long id) throws ParseException {
        authService.validateSelfOrAdmin(id);

        Optional<UserEntity> user = userRepository.findById(id);
        LocalDate dataAtual = LocalDate.now();


        if(user.isPresent()){
            UserEntity entity = user.get();
            UserResponseDTO userResponseDTO = new UserResponseDTO(entity);



            for (TreinoPagoEntity treino: userResponseDTO.getDiasTreinados() ) {
                LocalDate dataTreino = treino.getData();

                if(dataAtual.isEqual(dataAtual)){
                    return "Voce já treinou Hoje";
                }
                
            }
            Set<TreinoPagoEntity> lista = userResponseDTO.getDiasTreinados();
            TreinoPagoEntity treinoPagoEntity = new TreinoPagoEntity();
            treinoPagoEntity.setData(dataAtual);
            lista.add(treinoPagoRepository.save(treinoPagoEntity));
           entity.setTreinosPago(lista);
            userRepository.save(entity);
            return "Treino pago com sucesso";
        }else {
            return "Usuario não encontrado";
        }







    }

}
