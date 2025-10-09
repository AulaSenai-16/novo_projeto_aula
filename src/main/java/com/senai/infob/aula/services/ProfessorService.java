package com.senai.infob.aula.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.infob.aula.models.Professor;
import com.senai.infob.aula.repositories.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    public ProfessorRepository professorRepository;

    public Long count(){
        return professorRepository.count();
}

public Professor salvar(Professor professor){
    return professorRepository.save(professor);
}

public boolean deletar(Integer id){
    Professor professor = professorRepository.findById(id).get();
    if (professor != null) {
        professorRepository.deleteById(id);
        return true;
    }
    return false;
}


public Professor find(Integer id) {
    return professorRepository.findById(id).get();
}

public List<Professor> listarTodos(){
    return professorRepository.findAll();
}

    public Boolean atualizar(Professor professor, Integer id){
    Professor e = professorRepository.findById(id).get();
    if(professorRepository.existsById(id)){
        professor.setId(id);
        professorRepository.save(professor);
        return true;
    }
    return false;
    }

}
