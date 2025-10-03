package com.senai.infob.aula.serveces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.infob.aula.repositories.EstudanteRepository;

@Service
public class EstudanteService {
    @Autowired
    public EstudanteRepository estudanteRepository;

    public Long count(){
        return estudanteRepository.count();
}
}
