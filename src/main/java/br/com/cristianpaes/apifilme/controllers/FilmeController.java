package br.com.cristianpaes.apifilme.controllers;

import br.com.cristianpaes.apifilme.entities.Filme;
import br.com.cristianpaes.apifilme.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final List<Filme> filmes;

    @Autowired
    private FilmeService filmeService;

    public FilmeController(List<Filme> filmes) {
        this.filmes = new ArrayList<>();
    }

    @GetMapping
    public List<Filme>findAll(@RequestParam(required = false) String filme){
       return filmeService.findAll(filme);
    }

    @GetMapping("/{id}")
    public Filme findById(@PathVariable("id") Integer id){
            return filmeService.findById(id);

    }

    @PostMapping
    public ResponseEntity<Integer>add(@RequestBody Filme filme){
        Integer id = filmeService.add(filme);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Filme filme){
        filmeService.update(filme);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable("id") Integer id){
        filmeService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
