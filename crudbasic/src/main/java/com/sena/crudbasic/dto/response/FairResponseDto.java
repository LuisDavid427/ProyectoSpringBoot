package com.sena.crudbasic.dto.response;

import java.util.List;

import com.sena.crudbasic.model.Pavilion;

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
public class FairResponseDto {
    @JsonView(JsonViews.Detalle.class)
    private int idFair;
    @JsonView(JsonViews.Detalle.class)
    private String name;
    @JsonView(JsonViews.Detalle.class)
    private String description;
    @JsonView(JsonViews.Detalle.class)
    private List<Pavilion> pavilions;



}