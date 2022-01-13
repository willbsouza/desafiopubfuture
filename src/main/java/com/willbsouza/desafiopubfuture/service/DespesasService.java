package com.willbsouza.desafiopubfuture.service;

import com.willbsouza.desafiopubfuture.dto.DespesasDTO;
import com.willbsouza.desafiopubfuture.entities.Contas;
import com.willbsouza.desafiopubfuture.entities.Despesas;
import com.willbsouza.desafiopubfuture.entities.enums.TipoDespesa;
import com.willbsouza.desafiopubfuture.repository.ContasRepository;
import com.willbsouza.desafiopubfuture.repository.DespesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DespesasService {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private DespesasRepository despesasRepository;

    @Autowired
    private ContasRepository contasRepository;

    public List<Despesas> findAll(){
        return despesasRepository.findAll();
    }

    public Despesas findById(Integer id){
        return despesasRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID Despesa inexistente."));
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

    public Despesas save(DespesasDTO despesasDTO){
        Contas conta =contasRepository
                .findById(despesasDTO.getContaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta inexistente."));
        Despesas despesa = new Despesas();
        despesa.setValor(despesasDTO.getValor());
        despesa.setDataPagamento(despesasDTO.getDataPagamento());
        despesa.setDataPagamentoEsperado(despesasDTO.getDataPagamentoEsperado());
        despesa.setTipoDespesa(despesasDTO.getTipoDespesa());
        despesa.setConta(conta);
        return despesasRepository.save(despesa);
    }

    public Despesas update(Integer id, DespesasDTO despesasDTO){
        Contas conta = contasRepository
                .findById(despesasDTO.getContaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta inexistente."));
        Despesas obj = despesasRepository.findById(id).get();
        obj.setValor(despesasDTO.getValor());
        obj.setDataPagamento(despesasDTO.getDataPagamento());
        obj.setDataPagamentoEsperado(despesasDTO.getDataPagamentoEsperado());
        obj.setTipoDespesa(despesasDTO.getTipoDespesa());
        obj.setConta(conta);
        return despesasRepository.save(obj);
    }

    public void deleteById(Integer id){
        despesasRepository.deleteById(id);
    }

    public Double calcularDespesaTotal(){
        Double sum = despesasRepository.findAll()
                .stream()
                .map(x -> x.getValor())
                .reduce(0.0, Double::sum);
        return sum;
    }
}
