package br.senac.tads.dsw.projeto;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public List<Professor> obterTodos() {
        return professorRepository.findAll();
    }

    public Optional<Professor> obterPorId(int id) {
        return professorRepository.findById(id);
    }

    public Professor incluir(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor atualizar(int id, Professor professor) {
        professor.setId(id);
        return professorRepository.update(professor);
    }

    public void excluir(int id) {
        professorRepository.deleteById(id);
    }
}
