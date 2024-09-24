package com.example.financeiroApp.controllers;

import com.example.financeiroApp.model.GroupModel;
import com.example.financeiroApp.services.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public List<GroupModel> getAllGrupos() {
        return groupService.getAllGrupos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupModel> getGrupoById(@PathVariable Long id) {
        GroupModel groupModel = groupService.getGrupoById(id);
        if (groupModel != null) {
            return ResponseEntity.ok(groupModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public GroupModel createGrupo(@RequestBody GroupModel groupModel) {
        return groupService.saveGrupo(groupModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupModel> updateGrupo(@PathVariable Long id, @RequestBody GroupModel groupModel) {
        GroupModel updatedGrupo = groupService.updateGrupo(id, groupModel);
        if (updatedGrupo != null) {
            return ResponseEntity.ok(updatedGrupo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupo(@PathVariable Long id) {
        boolean deleted = groupService.deleteGrupo(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}