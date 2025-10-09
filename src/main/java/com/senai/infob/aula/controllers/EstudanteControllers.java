package com.senai.infob.aula.controllers;

import java.util.List;

import javax.print.DocFlavor.STRING;

import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.aula.models.Estudante;
import com.senai.infob.aula.services.EstudanteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class EstudanteControllers {

    @Autowired
    public EstudanteService estudanteService;
    
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

// @Find("/find/{id}")
// public String find(@PathVariable Integer id){
//   return estudanteService.buscarEstudante(estudante);
// }

@GetMapping("encontrar")
public Estudante find(Integer id) {
    return estudanteService.find(id);
}

@GetMapping("?listar")
public List<Estudante> listarTodos() {
    return estudanteService.listarTodos();
}


}
