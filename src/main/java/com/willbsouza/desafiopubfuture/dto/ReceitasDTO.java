package com.willbsouza.desafiopubfuture.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.willbsouza.desafiopubfuture.entities.enums.TipoReceita;

import java.util.Date;

public class ReceitasDTO {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataRecebimento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataRecebimentoEsperado;

    private Double valor;
    private String descricao;
    private TipoReceita tipoReceita;
    private Integer contaId;

    public ReceitasDTO() {
    }

    public ReceitasDTO(Double valor, Date dataRecebimento, Date dataRecebimentoEsperado, String descricao, TipoReceita tipoReceita, Integer contaId) {
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.descricao = descricao;
        this.tipoReceita = tipoReceita;
        this.contaId = contaId;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Date getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    public void setDataRecebimentoEsperado(Date dataRecebimentoEsperado) {
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public Integer getContaId() {
        return contaId;
    }

    public void setContaId(Integer contaId) {
        this.contaId = contaId;
    }


}
