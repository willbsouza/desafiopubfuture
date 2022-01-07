package com.willbsouza.desafiopubfuture.service;

import com.willbsouza.desafiopubfuture.entities.Despesas;
import com.willbsouza.desafiopubfuture.repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesasService {

    @Autowired
    private DespesasRepository despesasRepository;

    public List<Despesas> findAll(){
        return despesasRepository.findAll();
    }

    public Despesas findById(Integer id){
        return despesasRepository.findById(id).orElse(null);
    }

    public Despesas save(Despesas despesa){
        return despesasRepository.save(despesa);
    }

    public Despesas update(Integer id, Despesas despesa){
        Despesas obj = despesasRepository.findById(id).get();
        obj.setValor(despesa.getValor());
        obj.setDataPagamento(despesa.getDataPagamento());
        obj.setDataPagamentoEsperado(despesa.getDataPagamentoEsperado());
        obj.setTipoDespesa(despesa.getTipoDespesa());
        return despesasRepository.save(obj);
    }

    public void deleteById(Integer id){
        despesasRepository.deleteById(id);
    }
}
