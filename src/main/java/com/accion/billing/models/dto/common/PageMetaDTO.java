package com.accion.billing.models.dto.common;

import org.springframework.data.domain.Page;

public record PageMetaDTO<T>(
     int currentPage,
     int pageSize,
     int totalPages,
     boolean hasPrevious,
     boolean hasNext
) {
    public PageMetaDTO(Page<T> page) {
        this(page.getNumber(), page.getSize(), page.getTotalPages(), page.hasPrevious(), page.hasNext());
    }
}
