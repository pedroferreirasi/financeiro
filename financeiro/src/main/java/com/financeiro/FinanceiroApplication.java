package com.financeiro;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.financeiro.model.Categoria;
import com.financeiro.repository.CategoriaDao;
import com.financeiro.repository.LancamentoDao;

@SpringBootApplication
public class FinanceiroApplication implements CommandLineRunner {

	@Autowired
	private CategoriaDao categoriaDao;
	
	@Autowired
	private LancamentoDao lancamentoDao;
	
	public static void main(String[] args) {
		SpringApplication.run(FinanceiroApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Despesa Fixa");
		Categoria cat2 = new Categoria(null, "Presente");
		Categoria cat3 = new Categoria(null, "Feira");
		
		categoriaDao.saveAll(Arrays.asList(cat1, cat2, cat3));
	}

}
