package com.willbsouza.desafiopubfuture.service;

import com.willbsouza.desafiopubfuture.dto.ReceitasDTO;
import com.willbsouza.desafiopubfuture.entities.Contas;
import com.willbsouza.desafiopubfuture.entities.Receitas;
import com.willbsouza.desafiopubfuture.entities.enums.TipoReceita;
import com.willbsouza.desafiopubfuture.repository.ContasRepository;
import com.willbsouza.desafiopubfuture.repository.ReceitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceitasService {

    @Autowired
    private ReceitasRepository receitasRepository;

    @Autowired
    private ContasRepository contasRepository;

    public List<Receitas> findAll(){
        return receitasRepository.findAll();
    }

    public Receitas findById(Integer id){
        return receitasRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID de Receita inexistente."));
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

    public Receitas save(ReceitasDTO receitasDTO){
        Receitas receita = new Receitas();
        Integer contaId = receitasDTO.getContaId();
        Contas conta = contasRepository
                .findById(contaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta inexistente."));
        receita.setValor(receitasDTO.getValor());
        receita.setDataRecebimento(receitasDTO.getDataRecebimento());
        receita.setDataRecebimentoEsperado(receitasDTO.getDataRecebimentoEsperado());
        receita.setDescricao(receitasDTO.getDescricao());
        receita.setTipoReceita(receitasDTO.getTipoReceita());
        receita.setConta(conta);
        return receitasRepository.save(receita);
    }

    public Receitas update(Integer id, ReceitasDTO receitasDTO) {
        Integer contaId = receitasDTO.getContaId();
        Contas conta = contasRepository
                .findById(contaId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta inexistente."));
        Receitas obj = receitasRepository.findById(id).get();
        obj.setValor(receitasDTO.getValor());
        obj.setDataRecebimento(receitasDTO.getDataRecebimento());
        obj.setDataRecebimentoEsperado(receitasDTO.getDataRecebimentoEsperado());
        obj.setDescricao(receitasDTO.getDescricao());
        obj.setTipoReceita(receitasDTO.getTipoReceita());
        obj.setConta(conta);
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
