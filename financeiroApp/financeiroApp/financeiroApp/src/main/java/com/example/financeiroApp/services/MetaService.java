package com.example.financeiroApp.services;

import com.example.financeiroApp.model.MetaModel;
import com.example.financeiroApp.repositories.MetaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;

    public List<MetaModel> getAllMetas() {
        return metaRepository.findAll();
    }

    public MetaModel getMetaById(int id) {
        Optional<MetaModel> metaModel = metaRepository.findById(id);
        return metaModel.orElse(null);
    }

    public MetaModel saveMeta(MetaModel metaModel) {
        return metaRepository.save(metaModel);
    }

    public MetaModel updateMeta(int id, MetaModel metaModel) {
        Optional<MetaModel> existingMeta = metaRepository.findById(id);
        if (existingMeta.isPresent()) {
            MetaModel metaToUpdate = existingMeta.get();
            metaToUpdate.setTipo(metaModel.getTipo());
            metaToUpdate.setValor(metaModel.getValor());
            return metaRepository.save(metaToUpdate);
        } else {
            return null;
        }
    }

    public boolean deleteMeta(int id) {
        if (metaRepository.existsById(id)) {
            metaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}