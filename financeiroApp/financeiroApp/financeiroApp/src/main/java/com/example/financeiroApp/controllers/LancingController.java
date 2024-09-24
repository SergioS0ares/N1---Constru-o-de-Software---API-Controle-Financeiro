package com.example.financeiroApp.controllers;

import com.example.financeiroApp.model.LancingModel;
import com.example.financeiroApp.services.LancigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lancamentos")
public class LancingController {

    @Autowired
    private LancigService lancigService;

    @GetMapping
    public List<LancingModel> getAllLancamentos() {
        return lancigService.getAllLancamentos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LancingModel> getLancamentoById(@PathVariable Long id) {
        LancingModel lancingModel = lancigService.getLancamentoById(id);
        if (lancingModel != null) {
            return ResponseEntity.ok(lancingModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public LancingModel createLancamento(@RequestBody LancingModel lancingModel) {
        return lancigService.saveLancamento(lancingModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LancingModel> updateLancamento(@PathVariable Long id, @RequestBody LancingModel lancingModel) {
        LancingModel updatedLancamento = lancigService.updateLancamento(id, lancingModel);
        if (updatedLancamento != null) {
            return ResponseEntity.ok(updatedLancamento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLancamento(@PathVariable Long id) {
        boolean deleted = lancigService.deleteLancamento(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
