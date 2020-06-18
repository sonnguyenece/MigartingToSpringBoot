package com.codegym.service;

import java.util.Optional;

public interface IService<T> {
    Iterable<T> findAll();

    void insert(T model);

    void remove(Long id);

    Optional<T> findById(Long id);
}
