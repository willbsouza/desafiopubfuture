package com.willbsouza.desafiopubfuture.controller;

import com.willbsouza.desafiopubfuture.entities.Despesas;
import com.willbsouza.desafiopubfuture.entities.enums.TipoDespesa;
import com.willbsouza.desafiopubfuture.service.DespesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class DespesasController {

    @Autowired
    private DespesasService despesasService;

    @GetMapping("/despesas")
    public ResponseEntity<List<Despesas>> findAll(){
        return new ResponseEntity<List<Despesas>>(despesasService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/despesas/{id}")
    public ResponseEntity<Despesas> findById(@PathVariable Integer id){
        return new ResponseEntity<Despesas>(despesasService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/despesas/filtrodata")
    public ResponseEntity<List<Despesas>> findByDate(@RequestParam(name = "dataInicial") Date dataInicial, @RequestParam(name = "dataFinal") Date dataFinal){
        return new ResponseEntity<List<Despesas>>(despesasService.findByDate(dataInicial, dataFinal), HttpStatus.OK);
    }

    @GetMapping("/despesas/filtrotipo")
    public ResponseEntity<List<Despesas>> findByType(@RequestParam(name = "tipoDespesa") TipoDespesa tipoDespesa){
        return new ResponseEntity<List<Despesas>>(despesasService.findByType(tipoDespesa), HttpStatus.OK);
    }

    @GetMapping("/despesas/total")
    public ResponseEntity<Double> totalDespesa(){
        return new ResponseEntity<Double>(despesasService.calcularDespesaTotal(), HttpStatus.OK);
    }

    @PostMapping("/despesas")
    public ResponseEntity<Despesas> save(@RequestBody Despesas despesa){
        return new ResponseEntity<Despesas>(despesasService.save(despesa),HttpStatus.CREATED);
    }

    @PutMapping("/despesas/{id}")
    public ResponseEntity<Despesas> update(@PathVariable Integer id, @RequestBody Despesas despesa){
        return new ResponseEntity<Despesas>(despesasService.update(id, despesa), HttpStatus.OK);
    }
    @DeleteMapping("/despesas/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        despesasService.deleteById(id);
        return new ResponseEntity<String>("Despesa deletada com sucesso!", HttpStatus.NO_CONTENT);
    }
}
