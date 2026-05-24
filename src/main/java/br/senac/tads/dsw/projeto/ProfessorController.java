package br.senac.tads.dsw.ado2;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {
    
    private final ProfessorService professorService; 
    
    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @GetMapping("/{id}")
    public Professor obterPorId(@PathVariable int id) {
        Optional<Professor> optProfessor = professorService.obterPorId(id);
        if(optProfessor.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Professor não encontrado");
        }
        return optProfessor.get();
    }

    @PostMapping
    public ResponseEntity<?> incluir(@RequestBody @Valid Professor professor){
        Professor professorCriado = professorService.incluir(professor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(professorCriado.getId())
        .toUri();

        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(professorCriado);
    }

}
