package com.financeiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.model.Lancamento;
import com.financeiro.repository.LancamentoDao;
import com.financeiro.service.common.ServiceImpl;

@Service
public class LancamentoServiceImpl extends ServiceImpl<Lancamento, Long> {

	@Autowired
	public LancamentoServiceImpl(LancamentoDao entity) {
		super(entity);	
	}

}
