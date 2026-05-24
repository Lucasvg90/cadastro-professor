package br.senac.tads.dsw.ado2;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    
    private AtomicInteger contadorIds = new AtomicInteger(0);
    public Map<Integer, Professor> mapProfessores = new ConcurrentHashMap<>();
    
    public Optional<Professor> obterPorId(int id){
        return Optional.ofNullable(mapProfessores.get(id));
    }

    public Professor incluir(Professor professor){
        int novoId = contadorIds.incrementAndGet();
        professor.setId(novoId);

        mapProfessores.put(novoId, professor);
        return professor;

    }

}
