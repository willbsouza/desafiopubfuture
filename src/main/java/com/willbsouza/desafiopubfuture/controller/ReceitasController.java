package com.willbsouza.desafiopubfuture.controller;

import com.willbsouza.desafiopubfuture.entities.Receitas;
import com.willbsouza.desafiopubfuture.entities.enums.TipoReceita;
import com.willbsouza.desafiopubfuture.service.ReceitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ReceitasController {

    @Autowired
    private ReceitasService receitasService;

    @GetMapping("/receitas")
    public ResponseEntity<List<Receitas>> findAll(){
        return new ResponseEntity<List<Receitas>>(receitasService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/receitas/{id}")
    public ResponseEntity<Receitas> findById(@PathVariable Integer id){
        return new ResponseEntity<Receitas>(receitasService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/receitas/filtrodata")
    public ResponseEntity<List<Receitas>> findByDate(@RequestParam(name = "dataInicial") Date dataInicial, @RequestParam(name = "dataFinal") Date dataFinal){
        return new ResponseEntity<List<Receitas>>(receitasService.findByDate(dataInicial, dataFinal), HttpStatus.OK);
    }

    @GetMapping("/receitas/filtrotipo")
    public ResponseEntity<List<Receitas>> findByType(@RequestParam(name = "tipoReceita") TipoReceita tipoReceita){
        return new ResponseEntity<List<Receitas>>(receitasService.findByType(tipoReceita), HttpStatus.OK);
    }

    @PostMapping("/receitas")
    public ResponseEntity<Receitas> save(@RequestBody Receitas receita){
        return new ResponseEntity<Receitas>(receitasService.save(receita), HttpStatus.CREATED);
    }

    @PutMapping("/receitas/{id}")
    public ResponseEntity<Receitas> update(@PathVariable Integer id, @RequestBody Receitas receita){
        return new ResponseEntity<Receitas>(receitasService.update(id, receita), HttpStatus.OK);
    }

    @DeleteMapping("receitas/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        receitasService.deleteById(id);
        return new ResponseEntity<String>("Receita deletada com sucesso!", HttpStatus.NO_CONTENT);
    }
}
