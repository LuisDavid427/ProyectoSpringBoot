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

public class VisitorRequestDto {

    private int idVisitor;
    private int idPerson;    // FK a Person (@OneToOne)
    private int idVisitorType; // FK a VisitorType (@ManyToOne)


}