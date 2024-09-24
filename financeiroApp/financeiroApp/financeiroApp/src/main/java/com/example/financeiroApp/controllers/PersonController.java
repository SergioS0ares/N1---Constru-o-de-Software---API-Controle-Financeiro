package com.example.financeiroApp.controllers;

import com.example.financeiroApp.model.PersonModel;
import com.example.financeiroApp.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<PersonModel> getAllPessoas() {
        return personService.getAllPessoas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonModel> getPessoaById(@PathVariable Long id) {
        PersonModel personModel = personService.getPessoaById(id);
        if (personModel != null) {
            return ResponseEntity.ok(personModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PersonModel createPessoa(@RequestBody PersonModel personModel) {
        return personService.savePessoa(personModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonModel> updatePessoa(@PathVariable Long id, @RequestBody PersonModel personModel) {
        PersonModel updatedPessoa = personService.updatePessoa(id, personModel);
        if (updatedPessoa != null) {
            return ResponseEntity.ok(updatedPessoa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Long id) {
        boolean deleted = personService.deletePessoa(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}