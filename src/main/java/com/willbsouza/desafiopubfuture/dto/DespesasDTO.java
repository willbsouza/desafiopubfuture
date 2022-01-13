package com.willbsouza.desafiopubfuture.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.willbsouza.desafiopubfuture.entities.enums.TipoDespesa;

import java.util.Date;

public class DespesasDTO {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamentoEsperado;
    private Double valor;
    private TipoDespesa tipoDespesa;
    private Integer contaId;

    public DespesasDTO() {
    }

    public DespesasDTO(Date dataPagamento, Date dataPagamentoEsperado, Double valor, TipoDespesa tipoDespesa, Integer contaId) {
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.valor = valor;
        this.tipoDespesa = tipoDespesa;
        this.contaId = contaId;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public Integer getContaId() {
        return contaId;
    }

    public void setContaId(Integer contaId) {
        this.contaId = contaId;
    }
}
