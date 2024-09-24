package com.example.financeiroApp.controllers;

import com.example.financeiroApp.model.MetaModel;
import com.example.financeiroApp.services.MetaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @GetMapping
    public List<MetaModel> getAllMetas() {
        return metaService.getAllMetas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetaModel> getMetaById(@PathVariable int id) {
        MetaModel metaModel = metaService.getMetaById(id);
        if (metaModel != null) {
            return ResponseEntity.ok(metaModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MetaModel createMeta(@RequestBody MetaModel metaModel) {
        return metaService.saveMeta(metaModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetaModel> updateMeta(@PathVariable int id, @RequestBody MetaModel metaModel) {
        MetaModel updatedMeta = metaService.updateMeta(id, metaModel);
        if (updatedMeta != null) {
            return ResponseEntity.ok(updatedMeta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeta(@PathVariable int id) {
        boolean deleted = metaService.deleteMeta(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}