package com.example.financeiroApp.services;

import com.example.financeiroApp.model.PersonModel;
import com.example.financeiroApp.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<PersonModel> getAllPessoas() {
        return personRepository.findAll();
    }

    public PersonModel getPessoaById(Long id) {
        Optional<PersonModel> personModel = personRepository.findById(id);
        return personModel.orElse(null);
    }

    public PersonModel savePessoa(PersonModel personModel) {
        return personRepository.save(personModel);
    }

    public PersonModel updatePessoa(Long id, PersonModel personModel) {
        Optional<PersonModel> existingPessoa = personRepository.findById(id);
        if (existingPessoa.isPresent()) {
            PersonModel pessoaToUpdate = existingPessoa.get();
            pessoaToUpdate.setNome(personModel.getNome());
            pessoaToUpdate.setEmail(personModel.getEmail());
            pessoaToUpdate.setCpf(personModel.getCpf());
            pessoaToUpdate.setTelefone(personModel.getTelefone());
            return personRepository.save(pessoaToUpdate);
        } else {
            return null;
        }
    }

    public boolean deletePessoa(Long id) {
        if (personRepository.existsById(id)) {
            personRepository.deleteById(id);
            return true;
        }
        return false;
    }
}