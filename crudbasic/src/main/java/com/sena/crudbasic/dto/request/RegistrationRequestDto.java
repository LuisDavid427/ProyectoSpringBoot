package com.sena.crudbasic.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RegistrationRequestDto {

    private int idRegistration;
    private int idFair;
    private int idStand;
    private int idCompany;
    private int idLecture;
    private int idDemonstration;
    private int idSpeaker;
    private int idVisitor;


}