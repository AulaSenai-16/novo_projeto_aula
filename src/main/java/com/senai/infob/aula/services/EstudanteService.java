package com.senai.infob.aula.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.senai.infob.aula.models.Estudante;
import com.senai.infob.aula.repositories.EstudanteRepository;

@Service
public class EstudanteService {

    @Autowired
    public EstudanteRepository estudanteRepository;

    public Long count(){
        return estudanteRepository.count();
}

public Estudante salvar(Estudante estudante){
    return estudanteRepository.save(estudante);
}

public boolean deletar(Integer id){
    Estudante estudante = estudanteRepository.findById(id).get();
    if (estudante != null) {
        estudanteRepository.deleteById(id);
        return true;
    }
    return false;
}


public Estudante find(Integer id) {
    return estudanteRepository.findById(id).get();
}

public List<Estudante> listarTodos(){
    return estudanteRepository.findAll();
}

    public Boolean atualizar(Estudante estudante, Integer id){
    Estudante e = estudanteRepository.findById(id).get();
    if(estudanteRepository.existsById(id)){
        estudante.setId(id);
        estudanteRepository.save(estudante);
        return true;
    }
    return false;
    }

}