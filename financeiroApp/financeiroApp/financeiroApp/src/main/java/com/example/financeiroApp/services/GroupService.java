package com.example.financeiroApp.services;

import com.example.financeiroApp.model.GroupModel;
import com.example.financeiroApp.repositories.GroupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    @Autowired
    private GroupRepository groupRepository;

    public List<GroupModel> getAllGrupos() {
        return groupRepository.findAll();
    }

    public GroupModel getGrupoById(Long id) {
        Optional<GroupModel> groupModel = groupRepository.findById(id);
        return groupModel.orElse(null);
    }

    public GroupModel saveGrupo(GroupModel groupModel) {
        return groupRepository.save(groupModel);
    }

    public GroupModel updateGrupo(Long id, GroupModel groupModel) {
        Optional<GroupModel> existingGrupo = groupRepository.findById(id);
        if (existingGrupo.isPresent()) {
            GroupModel grupoToUpdate = existingGrupo.get();
            grupoToUpdate.setNome(groupModel.getNome());
            grupoToUpdate.setDescricao(groupModel.getDescricao());
            return groupRepository.save(grupoToUpdate);
        } else {
            return null;
        }
    }

    public boolean deleteGrupo(Long id) {
        if (groupRepository.existsById(id)) {
            groupRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
