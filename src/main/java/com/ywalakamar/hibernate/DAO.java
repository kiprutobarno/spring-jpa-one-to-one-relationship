package com.ywalakamar.hibernate;

import java.util.List;

public interface DAO<T> {
    public void create(T t);

    public T findOne(int id);

    public List<T> findAll();

    public void update(T t, int id);

    public void delete(int id);
}
