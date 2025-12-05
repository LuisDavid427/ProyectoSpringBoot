package com.sena.crudbasic.dto.response;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crudbasic.dto.view.JsonViews;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LectureResponseDto {
    @JsonView(JsonViews.Detalle.class)
    private int idLecture;
    @JsonView(JsonViews.Detalle.class)
    private String name;
    @JsonView(JsonViews.Detalle.class)
    private String description;

    // Constructores, Getters y Setters
    

}