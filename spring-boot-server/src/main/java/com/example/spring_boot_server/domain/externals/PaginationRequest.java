package com.example.spring_boot_server.domain.externals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaginationRequest {
    private String strFilter;
    private int pageNumber;
    private int pageSize;
    private String orderBy;
    private boolean orderAsc;
}