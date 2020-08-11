package com.company.demo.service;

import com.company.demo.entity.BaseEntity;
import com.company.demo.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseService<T extends BaseEntity, R extends BaseRepository<T>> {

    R repository;

    @Autowired
    public void setRepository(R repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T getById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
