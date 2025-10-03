package com.senai.infob.aula.services;

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

public void delete(Integer id){
    estudanteRepository.deleteById(id);

}

}
