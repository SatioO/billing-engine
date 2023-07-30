package com.accion.billing.models.mapper;

public interface EntityMapper<E, M> {
    E toEntity(M dto);
    M toModel(E entity);
}

