package com.willbsouza.desafiopubfuture.service;

import com.willbsouza.desafiopubfuture.entities.Despesas;
import com.willbsouza.desafiopubfuture.entities.enums.TipoDespesa;
import com.willbsouza.desafiopubfuture.repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DespesasService {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private DespesasRepository despesasRepository;

    public List<Despesas> findAll(){
        return despesasRepository.findAll();
    }

    public Despesas findById(Integer id){
        return despesasRepository.findById(id).orElse(null);
    }

    public List<Despesas> findByDate(Date dataInicial, Date dataFinal){
       return despesasRepository.findAll().stream()
               .filter(x -> (x.getDataPagamento().getTime() >= dataInicial.getTime() &&
                       x.getDataPagamento().getTime() <= dataFinal.getTime()))
               .collect(Collectors.toList());
    }

    public List<Despesas> findByType(TipoDespesa tipoDespesa){
        return despesasRepository.findAll().stream()
                .filter(x -> (x.getTipoDespesa().equals(tipoDespesa)))
                .collect(Collectors.toList());
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
        obj.setConta(despesa.getConta());
        return despesasRepository.save(obj);
    }

    public void deleteById(Integer id){
        despesasRepository.deleteById(id);
    }
}
