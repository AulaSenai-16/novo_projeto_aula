package com.senai.infob.aula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.aula.serveces.EstudanteService;


@RestController
public class EstudanteControllers {

    @Autowired
    public EstudanteService estudanteService;
    
    @GetMapping("/count")
    public Long count() {
        return estudanteService.count();
}

}
