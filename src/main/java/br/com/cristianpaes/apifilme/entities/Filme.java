package br.com.cristianpaes.apifilme.entities;

public class Filme {

    private Integer id;
    private String nome;
    private String diretor;
    private int ano;
    private int nota;

    public Filme(Integer id, String nome, String diretor, int ano, int nota) {
        this.id = id;
        this.nome = nome;
        this.diretor = diretor;
        this.ano = ano;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
