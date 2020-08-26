package com.codegym.repository;

import java.util.List;

public interface Repository<T> {
    void save(T t);

    List<T> getAll();

    T findById(Long id);
}
