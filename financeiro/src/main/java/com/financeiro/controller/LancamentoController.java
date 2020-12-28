package com.financeiro.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.financeiro.model.Lancamento;
import com.financeiro.service.LancamentoServiceImpl;

@RestController
@RequestMapping(value = "/lancamento")
public class LancamentoController {

	@Autowired
	private LancamentoServiceImpl service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public ResponseEntity<List<Lancamento>> getAll() {
		List<Lancamento> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Lancamento> getOne(@PathVariable Long id) {
		Lancamento entityResponse = service.findById(id);
		return ResponseEntity.ok().body(entityResponse);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Lancamento> save(@RequestBody Lancamento entity) {
		Lancamento entityResponse = service.add(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entityResponse.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Lancamento entity, @PathVariable Long id) {
		entity.setCodigo(id);
		service.update(entity);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
