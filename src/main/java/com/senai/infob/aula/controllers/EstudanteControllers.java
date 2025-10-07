package com.senai.infob.aula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.aula.models.Estudante;
import com.senai.infob.aula.repositories.EstudanteRepository;
import com.senai.infob.aula.services.EstudanteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EstudanteControllers {

    private final EstudanteRepository estudanteRepository;

    @Autowired
    public EstudanteService estudanteService;

    EstudanteControllers(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }
    
    @GetMapping("/count")
    public Long count() {
        return estudanteService.count();
}

@PostMapping("/salvar")
public Estudante salvar(@RequestBody Estudante estudante) {
    return estudanteService.salvar(estudante);
    
}

@DeleteMapping("/delete/{id}")
public String deletar(@PathVariable Integer id){
  boolean deletou = estudanteService.deletar(id);
  if (deletou){
    return "usuario removido com sucesso";
  }
  return "usuario falhoe";
     }


}
