package com.example.academiaapi.controller;
import com.example.academiaapi.entity.ExercicioEntity;
import com.example.academiaapi.service.ExercicioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @GetMapping
    public ResponseEntity<Page<ExercicioEntity>> findAllPaged(Pageable pageable) {
        Page<ExercicioEntity> list = exercicioService.findAllPaged(pageable);
        return ResponseEntity.ok(list);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioEntity> findById(@PathVariable Long id) {
        ExercicioEntity userResposeDTO = exercicioService.findById(id);
        return ResponseEntity.ok(userResposeDTO);
    }

    @PostMapping
    public ResponseEntity<ExercicioEntity> insert(@Valid @RequestBody ExercicioEntity exercicioEntity) {
       ExercicioEntity entity = exercicioService.insert(exercicioEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExercicioEntity> update(@PathVariable Long id, @Valid @RequestBody ExercicioEntity exercicioEntity){

        return ResponseEntity.ok(exercicioService.update(id,exercicioEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        exercicioService.deleteById(id);
        return new ResponseEntity<>("Exercicio deletado com sucesso", HttpStatus.OK);
    }

}
