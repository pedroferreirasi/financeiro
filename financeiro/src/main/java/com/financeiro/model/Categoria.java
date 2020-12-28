package com.financeiro.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Categoria() { }
	
	public Categoria(Long codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	@Id
	@Column(name = "cd_categoria")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	@Column(name = "ds_categoria")
	private String descricao;
	
	@OneToMany(mappedBy = "categoria")
	private List<Lancamento> lancamentos;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
