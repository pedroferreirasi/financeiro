package com.financeiro.model.domain;

public enum TipoLancamentoDomain {

	Despesa("D"), 
	Receita("R");

	TipoLancamentoDomain(String codigo) {
		this.codigo = codigo;
	}
	
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public static String getDescricao(String valor) {
		if (valor.equals(Despesa.getCodigo())) {
			return "Despesa";
		} else if (valor.equals(Receita.getCodigo())) {
			return "Receita";
		} else {
			return "";
		}
	}
	
	
}
