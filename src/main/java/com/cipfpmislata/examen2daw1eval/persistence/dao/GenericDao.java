package com.cipfpmislata.examen2daw1eval.persistence.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

public interface GenericDao {
    int DEFAULT_PAGE = 1;
    int DEFAULT_SIZE = 20;

    default Pageable toPageable(Integer page, Integer size) {
        int resolvedPage = page == null ? DEFAULT_PAGE : Math.max(page, 1);
        int resolvedSize = size == null ? DEFAULT_SIZE : Math.max(size, 1);
        return PageRequest.of(resolvedPage - 1, resolvedSize);
    }
}
