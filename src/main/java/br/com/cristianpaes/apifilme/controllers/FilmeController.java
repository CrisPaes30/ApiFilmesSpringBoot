package br.com.cristianpaes.apifilme.controllers;

import br.com.cristianpaes.apifilme.entities.Filme;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final List<Filme> filmes;

    public FilmeController(List<Filme> filmes) {
        this.filmes = new ArrayList<>();
    }

    @GetMapping
    public List<Filme>findAll(@RequestParam(required = false) String filme){
        if(filme != null){
           return filmes.stream().filter(flm -> flm.getNome().contains(filme))
                   .collect(Collectors.toList());
        }
        return filmes;
    }

    @GetMapping("/{id}")
    public Filme findById(@PathVariable("id") Integer id){
            return this.filmes.stream().filter(flm -> flm.getId().equals(id))
                    .findFirst()
                    .orElse(null);

    }

    @PostMapping
    public ResponseEntity<Integer>add(@RequestBody Filme filme){
        if(filme.getId()==null){
            filme.setId(filmes.size()+1);
        }
        filmes.add(filme);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Filme filme){
        filmes.stream().filter(flm -> flm.getId().equals(filme.getId()))
                .forEach(flm -> flm.setNome(filme.getNome()));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable("id") Integer id){
        filmes.removeIf(flm -> flm.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
