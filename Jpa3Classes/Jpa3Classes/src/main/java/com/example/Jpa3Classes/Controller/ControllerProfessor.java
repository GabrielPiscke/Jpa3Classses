package com.example.Jpa3Classes.Controller;

import com.example.Jpa3Classes.Entity.Professor;
import com.example.Jpa3Classes.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Professor")
public class ControllerProfessor {
    @Autowired
    private ProfessorRepository professorRepository;

    @PostMapping
    public ResponseEntity<Professor> created(@RequestBody Professor professor){
        Professor professorBd = professorRepository.save(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(professor);
    }
    @GetMapping
    public ResponseEntity<List<Professor>>getAll(){
        return ResponseEntity.ok(professorRepository.findAll());
    }
    @GetMapping("/{iud}")
    public ResponseEntity<Professor>getById(@PathVariable long id){
        Optional<Professor> professorOptional = professorRepository.findById(id);
        if(professorOptional.isPresent()){
            Professor professor = professorOptional.get();
            return ResponseEntity.ok(professor);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Professor updateProfessor) {
        Optional<Professor> optionalProfessor = professorRepository.findById(id);
        if (optionalProfessor.isPresent()) {
            Professor professor = optionalProfessor.get();
            professor.setNome(updateProfessor.getNome());
            professor.setCpf(updateProfessor.getCpf());
            return ResponseEntity.ok(professorRepository.save(professor));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professro não alterado");
        }
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<String> delete(@PathVariable Long id){
        Optional<Professor> optionalProfessor1 = professorRepository.findById(id);
        if(optionalProfessor1.isPresent()){
                Professor professor = optionalProfessor1.get();
                professorRepository.delete(professor);
                return ResponseEntity.ok("Professor deletado com sucesso!");
        }
        else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor não encontrado!");
        }

    }


}
