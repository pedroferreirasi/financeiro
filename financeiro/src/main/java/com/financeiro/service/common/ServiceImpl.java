package com.financeiro.service.common;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.service.exception.ObjectNotFoundException;


public abstract class ServiceImpl<T, PK> {
	
	protected JpaRepository<T, PK> entityDao;
	
	public ServiceImpl(JpaRepository<T, PK> entity) {
		this.entityDao = entity;
	}
	
	public T add(T entity) {
		return (T) entityDao.save(entity);
	}
	
	public T update(T entity) {
		return (T) entityDao.save(entity);
	}
	
	public void delete(T entity) {
		entityDao.delete(entity);
	}
	
	public void deleteById(PK id) {
		entityDao.deleteById(id);
	}
	
	public List<T> findAll() {
		return entityDao.findAll();
	}
	
	public T findById(PK id) {
		Optional<T> entity = entityDao.findById(id);
		return entity.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id));
	}
	
	public Page<T> findAll(Pageable pageable) {
		PageRequest pageRequest = PageRequest.of(pageable.getDefaultPageSize(), pageable.getMaxPageSize(), Direction.valueOf(pageable.getPrefix()), pageable.getQualifierDelimiter());
		return entityDao.findAll(pageRequest);
	}

}
