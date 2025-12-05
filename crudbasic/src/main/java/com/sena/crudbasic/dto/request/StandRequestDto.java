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

public class StandRequestDto {

    private int idStand;
    @NotBlank(message = "the name of the stand is required")
    @Size(min = 2, max = 50, message = "the name of the stand must be between 2 and 50 characters")
    private String standName;
    private int idPavilion; // FK a Pavilion
    private int idCompany;  // FK a Company


}