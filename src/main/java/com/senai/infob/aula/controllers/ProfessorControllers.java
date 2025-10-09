package com.senai.infob.aula.controllers;

import java.util.List;

import javax.print.DocFlavor.STRING;

import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.senai.infob.aula.models.Professor;
import com.senai.infob.aula.services.ProfessorService;
import com.senai.infob.aula.services.ProfessorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
public class ProfessorControllers {

    @Autowired
    public ProfessorService professorService;
    
    @GetMapping("/count")
    public Long count() {
        return professorService.count();
}

@PostMapping("/salvar")
public Professor salvar(@RequestBody Professor professor) {
    return professorService.salvar(professor);
    
}

@DeleteMapping("/delete/{id}")
public String deletar(@PathVariable Integer id){
  boolean deletou = professorService.deletar(id);
  if (deletou){
    return "usuario removido com sucesso";
  }
  return "usuario falhoe";
     }

// @Find("/find/{id}")
// public String find(@PathVariable Integer id){
//   return professorService.buscarEstudante(professor);
// }

@GetMapping("encontrar")
public Professor find(Integer id) {
    return professorService.find(id);
}

@GetMapping("listar")
public List<Professor> listarTodos() {
    return professorService.listarTodos();
}

@PutMapping("/atualizar-boolean/{id}")
public boolean atualizar(@PathVariable Integer id, @RequestBody Professor professor){
boolean atualizou = professorService.atualizar(professor, id);
if(atualizou){
  return true;
}
return false;
}


}

