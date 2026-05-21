package br.senac.tads.dsw.projeto;

import java.time.LocalDate;
import java.util.List;

public class ProfessorDto {

private Integer id;

	@NotBlank(message = "Preencha o username seu animal") // @NotNull + @NotEmpty
	@Size(min = 2, max = 32)
	private String username;

	@NotBlank
	@Size(min = 1, max = 100)
	private String nome;

	@NotBlank
	@Size(max = 100)
	@Email
	private String email;

	@NotNull
	@PastOrPresent
	private LocalDate dataNascimento;

	// Explicação da expressão regular abaixo em https://stackoverflow.com/a/18181478
	// Teste de regex online: https://regex101.com/
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W_]).{8,}")
	@NotBlank
	private String senha;

	private String senhaRepeticao;

	@Size(min = 1, message = "Escolha pelo menos 1 conhecimento")
	private List<String> conhecimentos;

    public ProfessorDto(Integer id, String username, String nome, String email, LocalDate dataNascimento, String senha,
            String senhaRepeticao, List<String> conhecimentos) {
        this.id = id;
        this.username = username;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.senhaRepeticao = senhaRepeticao;
        this.conhecimentos = conhecimentos;
    }

    public ProfessorDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhaRepeticao() {
        return senhaRepeticao;
    }

    public void setSenhaRepeticao(String senhaRepeticao) {
        this.senhaRepeticao = senhaRepeticao;
    }

    public List<String> getConhecimentos() {
        return conhecimentos;
    }

    public void setConhecimentos(List<String> conhecimentos) {
        this.conhecimentos = conhecimentos;
    }

    
    
}
