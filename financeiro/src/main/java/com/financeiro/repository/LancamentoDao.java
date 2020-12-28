package com.financeiro.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financeiro.model.Lancamento;

@Repository
public interface LancamentoDao extends JpaRepository<Lancamento, Long> {

	List<Lancamento> findByDataVencimentoBetween(Date dataInicial, Date dataFinal); 
}
