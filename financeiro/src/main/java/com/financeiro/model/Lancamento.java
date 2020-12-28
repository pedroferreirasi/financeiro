package com.financeiro.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.financeiro.model.domain.TipoLancamentoDomain;

@Entity
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Lancamento() { }
	
	@Id
	@Column(name = "cd_lancamento")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_criacao")
	private Date dataCriacao;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_vencimento")
	private Date dataVencimento;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_pagamento")
	private Date dataPagamento;
	
	@Column(name = "tipo_lancamento")
	private TipoLancamentoDomain tipoLancamento;
	
	@Column(name = "ds_lancamento")
	private String descricao;
		
	@ManyToOne
	@JoinColumn(name = "cd_categoria")
	private Categoria categoria;
	
	@Column(name = "valor")
	private float valor;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public TipoLancamentoDomain getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamentoDomain tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}	

}
