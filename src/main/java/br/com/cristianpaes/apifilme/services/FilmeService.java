package br.com.cristianpaes.apifilme.services;

import br.com.cristianpaes.apifilme.entities.Filme;
import br.com.cristianpaes.apifilme.exceptions.NoCreatedExceptions;
import br.com.cristianpaes.apifilme.exceptions.NotfoundExceptions;
import br.com.cristianpaes.apifilme.repositories.FilmeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FilmeService {


    @Autowired
    private FilmeRespository filmeRespository;


    public List<Filme> findAll(String filme) {
        if (filme != null) {
            return filmeRespository.findAll(filme);
        }
        return filmeRespository.findAll();
    }

    public Filme findById(Integer id) {
        if(id != null){
            throw new NotfoundExceptions();
        }
        return filmeRespository.findById(id);

    }

    public Integer add(Filme filme){
        if(filme.getId()==null) {
            filme.setId(filmeRespository.count() + 1);
        }
        filmeRespository.add(filme);
        return filme.getId();
    }


    public void update(final Filme filme) {
        filmeRespository.update(filme);

    }


    public void delete(final Integer id) {
        filmeRespository.delete(id);

    }


    public List<Filme> findAllExiste(Filme newFilme) {
        for (Filme filme : filmeRespository.findAll()) {
            if (filme.getNome().equalsIgnoreCase(newFilme.getNome()) &&
                    filme.getDiretor().equalsIgnoreCase(newFilme.getDiretor()) &&
                    filme.getAno().equals(newFilme.getAno())) {
                throw new NoCreatedExceptions();
            }
        }
        return filmeRespository.findAll();
    }

    public Integer notas(Filme filme) {
        Random rd = new Random();
        int rn = rd.nextInt(5);

        if (filme.getNota() == null) {
            filme.setNota(rn);
        }
        return filme.getNota();
    }
}

