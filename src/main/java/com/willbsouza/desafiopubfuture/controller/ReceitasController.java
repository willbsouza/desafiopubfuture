package com.willbsouza.desafiopubfuture.controller;

import com.willbsouza.desafiopubfuture.entities.Receitas;
import com.willbsouza.desafiopubfuture.service.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceitasController {

    @Autowired
    private ReceitasService receitasService;

    @GetMapping("/receitas")
    public List<Receitas> findAll(){
        return receitasService.findAll();
    }

    @GetMapping("/receitas/{id}")
    public Receitas findById(@PathVariable Integer id){
        return receitasService.findById(id);
    }

    @PostMapping("/receitas")
    public Receitas save(@RequestBody Receitas receita){
        return receitasService.save(receita);
    }

    @PutMapping("/receitas/{id}")
    public Receitas update(@PathVariable Integer id, @RequestBody Receitas receita){
        return receitasService.update(id, receita);
    }

    @DeleteMapping("receitas/{id}")
    public void deleteById(@PathVariable Integer id){
        receitasService.deleteById(id);
    }
}
