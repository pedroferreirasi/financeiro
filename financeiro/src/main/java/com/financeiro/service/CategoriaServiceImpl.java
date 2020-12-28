package com.financeiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financeiro.model.Categoria;
import com.financeiro.repository.CategoriaDao;
import com.financeiro.service.common.ServiceImpl;

@Service
public class CategoriaServiceImpl extends ServiceImpl<Categoria, Long>  {

	@Autowired
	public CategoriaServiceImpl(CategoriaDao entity) {
		super(entity);	
	}
}
