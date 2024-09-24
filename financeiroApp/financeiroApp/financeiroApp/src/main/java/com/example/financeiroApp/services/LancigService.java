package com.example.financeiroApp.services;

import com.example.financeiroApp.model.LancingModel;
import com.example.financeiroApp.repositories.LancingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancigService {

    @Autowired
    private LancingRepository lancingRepository;

    public List<LancingModel> getAllLancamentos() {
        return lancingRepository.findAll();
    }

    public LancingModel getLancamentoById(Long id) {
        Optional<LancingModel> lancingModel = lancingRepository.findById(id);
        return lancingModel.orElse(null);
    }

    public LancingModel saveLancamento(LancingModel lancingModel) {
        return lancingRepository.save(lancingModel);
    }

    public LancingModel updateLancamento(Long id, LancingModel lancingModel) {
        Optional<LancingModel> existingLancamento = lancingRepository.findById(id);
        if (existingLancamento.isPresent()) {
            LancingModel lancamentoToUpdate = existingLancamento.get();
            lancamentoToUpdate.setData(lancingModel.getData());
            lancamentoToUpdate.setValor(lancingModel.getValor());
            lancamentoToUpdate.setTipo(lancingModel.getTipo());
            lancamentoToUpdate.setNome(lancingModel.getNome());
            lancamentoToUpdate.setDescricao(lancingModel.getDescricao());
            lancamentoToUpdate.setCategoria(lancingModel.getCategoria());
            return lancingRepository.save(lancamentoToUpdate);
        } else {
            return null;
        }
    }

    public boolean deleteLancamento(Long id) {
        if (lancingRepository.existsById(id)) {
            lancingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
