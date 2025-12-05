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
public class SpeakerResponseDto {

    @JsonView(JsonViews.Detalle.class)
    private int idSpeaker;
    @JsonView(JsonViews.Detalle.class)
    private int idPerson; // FK a Person


}