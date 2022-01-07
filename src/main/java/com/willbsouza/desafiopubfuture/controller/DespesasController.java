package com.willbsouza.desafiopubfuture.controller;

import com.willbsouza.desafiopubfuture.entities.Despesas;
import com.willbsouza.desafiopubfuture.service.DespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DespesasController {

    @Autowired
    private DespesasService despesasService;

    @GetMapping(value = "/despesas")
    public List<Despesas> findAll(){
        return despesasService.findAll();
    }

    @GetMapping(value = "/despesas/{id}")
    public Despesas findById(@PathVariable Integer id){
        return despesasService.findById(id);
    }

    @PostMapping(value = "/despesas")
    public Despesas save(@RequestBody Despesas despesa){
        return despesasService.save(despesa);
    }

    @PutMapping(value = "/despesas/{id}")
    public Despesas update(@PathVariable Integer id, @RequestBody Despesas despesa){
        return despesasService.update(id, despesa);
    }
    @DeleteMapping(value = "/despesas/{id}")
    public void deleteById(@PathVariable Integer id) {
        despesasService.deleteById(id);
    }
}
