package com.willbsouza.desafiopubfuture.controller;

import com.willbsouza.desafiopubfuture.dto.ReceitasDTO;
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
@RequestMapping("/receitas")
public class ReceitasController {

    @Autowired
    private ReceitasService receitasService;

    @GetMapping
    public ResponseEntity<List<Receitas>> findAll(){
        return new ResponseEntity<List<Receitas>>(receitasService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receitas> findById(@PathVariable Integer id){
        return new ResponseEntity<Receitas>(receitasService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/filtrodata")
    public ResponseEntity<List<Receitas>> findByDate(@RequestParam(name = "dataInicial") Date dataInicial, @RequestParam(name = "dataFinal") Date dataFinal){
        return new ResponseEntity<List<Receitas>>(receitasService.findByDate(dataInicial, dataFinal), HttpStatus.OK);
    }

    @GetMapping("/filtrotipo")
    public ResponseEntity<List<Receitas>> findByType(@RequestParam(name = "tipoReceita") TipoReceita tipoReceita){
        return new ResponseEntity<List<Receitas>>(receitasService.findByType(tipoReceita), HttpStatus.OK);
    }

    @GetMapping("/total")
    public ResponseEntity<Double> totalReceita(){
        return new ResponseEntity<Double>(receitasService.calcularReceitaTotal(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Receitas> save(@RequestBody ReceitasDTO receitasDTO){
        return new ResponseEntity<Receitas>(receitasService.save(receitasDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receitas> update(@PathVariable Integer id, @RequestBody ReceitasDTO receitasDTO){
        return new ResponseEntity<Receitas>(receitasService.update(id, receitasDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        receitasService.deleteById(id);
        return new ResponseEntity<String>("Receita deletada com sucesso!", HttpStatus.NO_CONTENT);
    }
}
