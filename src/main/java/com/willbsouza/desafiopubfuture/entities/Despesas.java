package com.willbsouza.desafiopubfuture.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.willbsouza.desafiopubfuture.entities.enums.TipoDespesa;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Despesas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double valor;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamentoEsperado;
    private TipoDespesa tipoDespesa;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Contas conta;

    public Despesas() {
    }

    public Despesas(Integer id, Double valor, Date dataPagamento, Date dataPagamentoEsperado, TipoDespesa tipoDespesa, Contas conta) {
        this.id = id;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
        this.conta = conta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getDataPagamentoEsperado() {
        return dataPagamentoEsperado;
    }

    public void setDataPagamentoEsperado(Date dataPagamentoEsperado) {
        this.dataPagamentoEsperado = dataPagamentoEsperado;
    }

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Contas getConta() {
        return conta;
    }

    public void setConta(Contas conta) {
        this.conta = conta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Despesas despesas = (Despesas) o;
        return Objects.equals(id, despesas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
