package com.example.demodocker.service;

import java.util.List;

public interface CrudCommonService {
    void save(Object object);

    List<Object> getAll();

    void delete(Long id);
}
