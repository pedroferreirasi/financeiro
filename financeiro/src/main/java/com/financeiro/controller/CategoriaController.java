package com.financeiro.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.financeiro.controller.dto.CategoriaDTO;
import com.financeiro.model.Categoria;
import com.financeiro.service.CategoriaServiceImpl;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaServiceImpl service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public Page<Categoria> listAll(Pageable pageable) {
		Page<Categoria> lista = service.findAll(pageable);
		List<CategoriaDTO> listaRetorno = lista.stream().map(
				obj -> new CategoriaDTO(obj.getCodigo(), obj.getDescricao())).collect(Collectors.toList());
		return lista;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Categoria> listOne(@PathVariable Long id) {
		Categoria entidade = service.findById(id);
		return ResponseEntity.ok().body(entidade);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Categoria> save(@RequestBody Categoria entity) {
		Categoria entityResponse = service.add(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entityResponse.getCodigo()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Void> update(@RequestBody Categoria entity, @PathVariable Long id) {	
		entity.setCodigo(id);
		service.update(entity);

		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
    }
}
