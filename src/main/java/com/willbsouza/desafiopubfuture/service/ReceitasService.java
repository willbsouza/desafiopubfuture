package com.willbsouza.desafiopubfuture.service;

import com.willbsouza.desafiopubfuture.entities.Receitas;
import com.willbsouza.desafiopubfuture.repository.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitasService {

    @Autowired
    private ReceitasRepository receitasRepository;

    public List<Receitas> findAll(){
        return receitasRepository.findAll();
    }

    public Receitas findById(Integer id){
        return receitasRepository.findById(id).orElse(null);
    }

    public Receitas save(Receitas receita){
        return receitasRepository.save(receita);
    }

    public Receitas update(Integer id, Receitas receita){
        Receitas obj = receitasRepository.findById(id).get();
        obj.setValor(receita.getValor());
        obj.setDataRecebimento(receita.getDataRecebimento());
        obj.setDataRecebimentoEsperado(receita.getDataRecebimentoEsperado());
        obj.setDescricao(receita.getDescricao());
        obj.setTipoReceita(receita.getTipoReceita());
        return receitasRepository.save(obj);
    }

    public void deleteById(Integer id){
        receitasRepository.deleteById(id);
    }
}
