package com.willbsouza.desafiopubfuture.entities;

import com.willbsouza.desafiopubfuture.entities.enums.TipoConta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Contas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double saldo;
    private TipoConta tipoConta;
    private String instituicaoFinanceira;

    public Contas() {
    }

    public Contas(Integer id, Double saldo, TipoConta tipoConta, String instituicaoFinanceira) {
        this.id = id;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getInstituicaoFinanceira() {
        return instituicaoFinanceira;
    }

    public void setInstituicaoFinanceira(String instituicaoFinanceira) {
        this.instituicaoFinanceira = instituicaoFinanceira;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contas contas = (Contas) o;
        return Objects.equals(id, contas.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
