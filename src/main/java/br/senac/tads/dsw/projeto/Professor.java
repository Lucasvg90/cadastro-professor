package br.senac.tads.dsw.ado2;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Professor {
    
    private Integer id;

    @NotBlank @Size(max = 100)
    private String nome;
    
    @NotBlank @Size(max = 20)
    private String matricula;
    
    @NotBlank @Size(max = 50)
    private String disciplina;

    public Professor() {
    }

    public Professor(Integer id, String nome, String matricula, String disciplina) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.disciplina = disciplina;
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
    
    
    

}
