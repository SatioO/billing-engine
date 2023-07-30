package com.accion.billing.models.dto.common;

public record PageDTO<T>(
    T data,

    PageMetaDTO meta
) {}