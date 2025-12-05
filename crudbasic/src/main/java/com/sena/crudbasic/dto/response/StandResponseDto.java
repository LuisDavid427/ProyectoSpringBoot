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
public class StandResponseDto {
    
    @JsonView(JsonViews.Detalle.class)
    private int idStand;
    @JsonView(JsonViews.Detalle.class)
    private String standName;
    @JsonView(JsonViews.Detalle.class)
    private int idPavilion; // FK a Pavilion
    @JsonView(JsonViews.Detalle.class)
    private int idCompany;  // FK a Company


}