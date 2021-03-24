package br.com.cristianpaes.apifilme.services;

import br.com.cristianpaes.apifilme.entities.Filme;
import br.com.cristianpaes.apifilme.exceptions.NoCreatedExceptions;
import br.com.cristianpaes.apifilme.repositories.FilmeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {


    @Autowired
    private FilmeRespository filmeRespository;


    public List<Filme> findAll(String filme){
        if(filme != null){
            return filmeRespository.findAll(filme);
        }
        return filmeRespository.findAll();
    }

    public Filme findById(Integer id){
        return filmeRespository.findById(id);

    }

    public Integer add(Filme filme){
        if(filme.getId()==null) {
            filme.setId(filmeRespository.count() + 1);
        }
        filmeRespository.add(filme);
        return filme.getId();
    }


    public void update(final Filme filme){
        filmeRespository.update(filme);

    }


    public void delete (final Integer id){
        filmeRespository.delete(id);

    }


    public List<Filme> findAllExiste(Filme newFilme){
        for (Filme filme : filmeRespository.findAll()) {
            if (filme.getNome().equalsIgnoreCase(newFilme.getNome())){
                throw new NoCreatedExceptions();
            }
        }
        return filmeRespository.findAll();
    }
}

