package com.willbsouza.desafiopubfuture.controller;

import com.willbsouza.desafiopubfuture.entities.Contas;
import com.willbsouza.desafiopubfuture.service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContasController {

    @Autowired
    private ContasService contasService;

    @GetMapping
    public ResponseEntity<List<Contas>> findAll(){
        return new ResponseEntity<List<Contas>>(contasService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contas> findById(@PathVariable Integer id){
        return new ResponseEntity<Contas>(contasService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/total")
    public ResponseEntity<Double> totalContas(){
        return new ResponseEntity<Double>(contasService.calcularTotal(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contas> save(@RequestBody Contas conta){
        return new ResponseEntity<Contas>(contasService.save(conta), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contas> update(@PathVariable Integer id, @RequestBody Contas conta){
        return new ResponseEntity<Contas>(contasService.update(id, conta), HttpStatus.OK);
    }

    @PutMapping("/transferencia")
    public ResponseEntity<Contas> transferirSaldo(@RequestParam(name = "idOrigem") Integer idOrigem,
                                                   @RequestParam(name = "idDestino") Integer idDestino,
                                                   @RequestParam(name = "valor") Double valor) {
        return new ResponseEntity<Contas>(contasService.transferirSaldo(idOrigem, idDestino, valor), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id) {
        contasService.deleteById(id);
        return new ResponseEntity<String>("Conta deletada com sucesso!", HttpStatus.NO_CONTENT);
    }
}
