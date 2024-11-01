package com.gui_motas.workshop_spring_jpa.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import lombok.*;

public @Getter @Setter @NoArgsConstructor @AllArgsConstructor class StandartError implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
