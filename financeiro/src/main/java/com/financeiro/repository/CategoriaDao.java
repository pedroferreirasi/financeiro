package com.financeiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financeiro.model.Categoria;

@Repository
public interface CategoriaDao extends JpaRepository<Categoria, Long> {

}
