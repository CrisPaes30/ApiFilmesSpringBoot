package br.com.cristianpaes.apifilme.repositories;


import br.com.cristianpaes.apifilme.entities.Filme;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FilmeRespository {

    private final List<Filme> filmes;

    public FilmeRespository(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public List<Filme> findAll() {
        return filmes;
    }

    public List<Filme> findAll(final String filme) {
        return filmes.stream().filter(flm -> flm.getNome().contains(filme))
                .collect(Collectors.toList());
    }


    public Filme findById(Integer id){
        return this.filmes.stream().filter(flm -> flm.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public int count(){
        return filmes.size();
    }

    public void add(Filme filme){
        this.filmes.add(filme);
    }


    public void update(final Filme filme){
        filmes.stream().filter(flm -> flm.getId().equals(filme.getId()))
                .forEach(flm -> flm.setNome(filme.getNome()));

    }


    public void delete (Integer id){
        filmes.removeIf(flm -> flm.getId().equals(id));

    }

}
