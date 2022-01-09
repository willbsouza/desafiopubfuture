package com.willbsouza.desafiopubfuture.service;

import com.willbsouza.desafiopubfuture.entities.Contas;
import com.willbsouza.desafiopubfuture.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContasService {

    @Autowired
    private ContasRepository contasRepository;

    public List<Contas> findAll(){
        return contasRepository.findAll();
    }

    public Contas findById(Integer id){
        return contasRepository.findById(id).orElse(null);
    }

    public Contas save(Contas conta){
        return contasRepository.save(conta);
    }

    public Contas update(Integer id, Contas conta){
        Contas obj = contasRepository.findById(id).get();
        obj.setSaldo(conta.getSaldo());
        obj.setTipoConta(conta.getTipoConta());
        obj.setInstituicaoFinanceira(conta.getInstituicaoFinanceira());
        return contasRepository.save(obj);
    }

    public void deleteById(Integer id){
        contasRepository.deleteById(id);
    }

    public Double calcularTotal(){
        Double sum = contasRepository.findAll()
                .stream()
                .map(x -> x.getSaldo())
                .reduce(0.0, Double::sum);
        return sum;
    }

    public Contas transferirSaldo(Integer idOrigem, Integer idDestino, Double valor){
        Contas origem = contasRepository.findById(idOrigem).get();
        Contas destino = contasRepository.findById(idDestino).get();
        origem.setSaldo(origem.getSaldo() - valor);
        destino.setSaldo(destino.getSaldo() + valor);
        contasRepository.saveAndFlush(origem);
        return contasRepository.saveAndFlush(destino);
    }
}
