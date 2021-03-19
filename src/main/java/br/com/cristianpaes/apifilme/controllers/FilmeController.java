package br.com.cristianpaes.apifilme.controllers;

import br.com.cristianpaes.apifilme.entities.Filme;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FilmeController {

    private final List<Filme> filmes;

    public FilmeController(List<Filme> filmes) {
        this.filmes = new ArrayList<>();
    }

    @GetMapping
    public List<Filme>findAll(@RequestParam String filme){
        if(filme != null){
           return filmes.stream().filter(flm -> flm.getNome().contains(filme))
                   .collect(Collectors.toList());
        }
        return filmes;
    }

    @GetMapping("/{id}")
    public Filme findById(@PathVariable("id") Integer id){
            return this.filmes.stream().filter(filme -> filme.getId().equals(id))
                    .findFirst()
                    .orElse(null);
        }
    }


}
