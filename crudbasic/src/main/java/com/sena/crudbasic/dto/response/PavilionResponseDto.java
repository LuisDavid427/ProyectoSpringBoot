package com.sena.crudbasic.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crudbasic.dto.view.JsonViews;
import com.sena.crudbasic.model.Stand;

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
public class PavilionResponseDto {
    @JsonView(JsonViews.Detalle.class)
    private int idPavilion;
    @JsonView(JsonViews.Detalle.class)
    private String name;
    @JsonView(JsonViews.Detalle.class)
    private int idTheme; // FK a Theme
    @JsonView(JsonViews.Detalle.class)
    private int idFair;  // FK a Fair
    @JsonView(JsonViews.Detalle.class)
    private List<Stand> stands;
    

}