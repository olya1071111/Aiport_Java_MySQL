package com.academy.model.dao;

import java.util.List;

public interface DefaultDao <T, M> {
    void save(T entity);

    void deleteById(M id);

    List<T> getAll();

    T getById(M id);
}
