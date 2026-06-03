package br.senac.tads.dsw.projeto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Professor {
    
    private Integer id;

    @NotBlank @Size(min = 5, max = 100)
    private String nome;
    
    @NotBlank @Size(min = 9, max = 9)
    private String matricula;
    
    @NotBlank @Size(min = 5, max = 50)
    private String disciplina;

    @NotBlank @Size(min = 5, max = 100)
    private String observacoes;

    private boolean ativo;

    public Professor() {
    }

    public Professor(Integer id, String nome, String matricula, String disciplina, boolean ativo, String observacoes) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.disciplina = disciplina;
        this.ativo = ativo;
        this.observacoes = observacoes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    
    
    

}
