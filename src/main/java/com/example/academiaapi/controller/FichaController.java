package com.example.academiaapi.controller;

import com.example.academiaapi.entity.FichaEntity;
import com.example.academiaapi.service.FichaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/ficha")
public class FichaController {
    private final FichaService fichaService;

    public FichaController(FichaService fichaService) {
        this.fichaService = fichaService;
    }


    @GetMapping
    public ResponseEntity<Page<FichaEntity>> findAllPaged(Pageable pageable) {
        Page<FichaEntity> list = fichaService.findAllPaged(pageable);
        return ResponseEntity.ok(list);

    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaEntity> findById(@PathVariable Long id) {
        FichaEntity entity = fichaService.findById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<FichaEntity> insert(@Valid @RequestBody FichaEntity fichaEntity) {
        FichaEntity entity = fichaService.insert(fichaEntity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(entity.getId()).toUri();
        return ResponseEntity.created(uri).body(entity);
    }


    @PutMapping("/{id}")
    public ResponseEntity<FichaEntity> update(@PathVariable Long id, @Valid @RequestBody FichaEntity fichaEntity) {

        return ResponseEntity.ok(fichaService.update(id, fichaEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        fichaService.deleteById(id);
        return new ResponseEntity<>("Exercicio deletado com sucesso", HttpStatus.OK);
    }
}
