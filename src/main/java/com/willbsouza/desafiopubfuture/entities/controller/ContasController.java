package com.willbsouza.desafiopubfuture.entities.controller;

import com.willbsouza.desafiopubfuture.entities.Contas;
import com.willbsouza.desafiopubfuture.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContasController {

    @Autowired
    private ContasService contasService;

    @GetMapping(value = "/contas")
    public List<Contas> findAll(){
        return contasService.findAll();
    }

    @GetMapping(value = "/contas/{id}")
    public Contas findById(@PathVariable Integer id){
        return contasService.findById(id);
    }

    @PostMapping(value = "/contas")
    public Contas save(@RequestBody Contas conta){
        return contasService.save(conta);
    }

    @PutMapping(value = "/contas/{id}")
    public Contas update(@PathVariable Integer id, @RequestBody Contas conta){
        return contasService.update(id, conta);
    }
    @DeleteMapping(value = "/contas/{id}")
    public void deleteById(@PathVariable Integer id) {
        contasService.deleteById(id);
    }
}
