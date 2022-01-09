package com.willbsouza.desafiopubfuture.service;

import com.willbsouza.desafiopubfuture.entities.Receitas;
import com.willbsouza.desafiopubfuture.entities.enums.TipoReceita;
import com.willbsouza.desafiopubfuture.repository.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Receitas> findByDate(Date dataInicial, Date dataFinal){
        return receitasRepository.findAll().stream()
                .filter(x -> (x.getDataRecebimento().getTime() >= dataInicial.getTime() &&
                        x.getDataRecebimento().getTime() <= dataFinal.getTime()))
                .collect(Collectors.toList());
    }

    public List<Receitas> findByType(TipoReceita tipoReceita){
        return receitasRepository.findAll().stream()
                .filter(x -> (x.getTipoReceita().equals(tipoReceita)))
                .collect(Collectors.toList());
    }

    public Receitas save(Receitas receita){
        return receitasRepository.save(receita);
    }

    public Receitas update(Integer id, Receitas receita) {
        Receitas obj = receitasRepository.findById(id).get();
        obj.setValor(receita.getValor());
        obj.setDataRecebimento(receita.getDataRecebimento());
        obj.setDataRecebimentoEsperado(receita.getDataRecebimentoEsperado());
        obj.setDescricao(receita.getDescricao());
        obj.setTipoReceita(receita.getTipoReceita());
        obj.setConta(receita.getConta());
        return receitasRepository.save(obj);
    }

    public void deleteById(Integer id){
        receitasRepository.deleteById(id);
    }

    public Double calcularReceitaTotal(){
        Double sum = receitasRepository.findAll()
                .stream()
                .map(x -> x.getValor())
                .reduce(0.0, Double::sum);
        return sum;
    }
}
