package com.example.demo.repository;

import com.example.demo.entity.BaseEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BaseRepository<T extends BaseEntity> extends CrudRepository<T, Long> {

    List<T> findAll();
}