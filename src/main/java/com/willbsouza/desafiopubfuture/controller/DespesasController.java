package com.willbsouza.desafiopubfuture.controller;

import com.willbsouza.desafiopubfuture.dto.DespesasDTO;
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
@RequestMapping("/despesas")
public class DespesasController {

    @Autowired
    private DespesasService despesasService;

    @GetMapping
    public ResponseEntity<List<Despesas>> findAll(){
        return new ResponseEntity<List<Despesas>>(despesasService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despesas> findById(@PathVariable Integer id){
        return new ResponseEntity<Despesas>(despesasService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/filtrodata")
    public ResponseEntity<List<Despesas>> findByDate(@RequestParam(name = "dataInicial") Date dataInicial, @RequestParam(name = "dataFinal") Date dataFinal){
        return new ResponseEntity<List<Despesas>>(despesasService.findByDate(dataInicial, dataFinal), HttpStatus.OK);
    }

    @GetMapping("/filtrotipo")
    public ResponseEntity<List<Despesas>> findByType(@RequestParam(name = "tipoDespesa") TipoDespesa tipoDespesa){
        return new ResponseEntity<List<Despesas>>(despesasService.findByType(tipoDespesa), HttpStatus.OK);
    }

    @GetMapping("/total")
    public ResponseEntity<Double> totalDespesa(){
        return new ResponseEntity<Double>(despesasService.calcularDespesaTotal(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Despesas> save(@RequestBody DespesasDTO despesasDTO){
        return new ResponseEntity<Despesas>(despesasService.save(despesasDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despesas> update(@PathVariable Integer id, @RequestBody DespesasDTO despesasDTO){
        return new ResponseEntity<Despesas>(despesasService.update(id, despesasDTO), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        despesasService.deleteById(id);
        return new ResponseEntity<String>("Despesa deletada com sucesso!", HttpStatus.NO_CONTENT);
    }
}
