package br.senac.tads.dsw.projeto;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class ProfessorRepository {

    private static final RowMapper<Professor> PROFESSOR_ROW_MAPPER = (rs, rowNum) -> {
        Professor professor = new Professor();
        professor.setId(rs.getInt("id"));
        professor.setNome(rs.getString("nome"));
        professor.setMatricula(rs.getString("matricula"));
        professor.setDisciplina(rs.getString("disciplina"));
        professor.setAtivo(rs.getBoolean("ativo"));
        return professor;
    };

    private final JdbcTemplate jdbcTemplate;

    public ProfessorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Professor> findAll() {
        return jdbcTemplate.query(
                "SELECT id, nome, matricula, disciplina, ativo FROM PROFESSORES ORDER BY id",
                PROFESSOR_ROW_MAPPER);
    }

    public Optional<Professor> findById(int id) {
        return jdbcTemplate.query(
                "SELECT id, nome, matricula, disciplina, ativo FROM PROFESSORES WHERE id = ?",
                PROFESSOR_ROW_MAPPER, id).stream().findFirst();
    }

    public Professor save(Professor professor) {
        String sql = "INSERT INTO PROFESSORES (nome, matricula, disciplina, ativo) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, professor.getNome());
            ps.setString(2, professor.getMatricula());
            ps.setString(3, professor.getDisciplina());
            ps.setBoolean(4, professor.isAtivo());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            professor.setId(key.intValue());
        }

        return professor;
    }

    public Professor update(Professor professor) {
        jdbcTemplate.update(
                "UPDATE PROFESSORES SET nome = ?, matricula = ?, disciplina = ?, ativo = ? WHERE id = ?",
                professor.getNome(),
                professor.getMatricula(),
                professor.getDisciplina(),
                professor.isAtivo(),
                professor.getId());
        return professor;
    }

    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM PROFESSORES WHERE id = ?", id);
    }
}
