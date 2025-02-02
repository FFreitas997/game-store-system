package com.ffreitas.gamestoreserver.common;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponsePageDto<S extends Serializable> implements Serializable {

    private List<S> content;
    private int number;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;
    private boolean first;
}
