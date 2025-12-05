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
public class RegistrationResponseDto {

    @JsonView(JsonViews.Detalle.class)
    private int idRegistration;
    @JsonView(JsonViews.Detalle.class)
    private int idFair;
    @JsonView(JsonViews.Detalle.class)
    private int idStand;
    @JsonView(JsonViews.Detalle.class)
    private int idCompany;
    @JsonView(JsonViews.Detalle.class)
    private int idLecture;
    @JsonView(JsonViews.Detalle.class)
    private int idDemonstration;
    @JsonView(JsonViews.Detalle.class)
    private int idSpeaker;
    @JsonView(JsonViews.Detalle.class)
    private int idVisitor;


}