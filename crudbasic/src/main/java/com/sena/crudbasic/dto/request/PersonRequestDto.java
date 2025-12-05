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

public class PersonRequestDto {

    private int idPerson;
    @NotBlank(message = "the name is required")
    @Size(min = 2, max = 50, message = "the name must be between 2 and 50 characters")
    private String name;
    @NotBlank(message = "the dni is required")
    @Size(min = 5, max = 20, message = "the dni must be between 5 and 20 characters")
    private String dni;
    @NotBlank(message = "the phone is required")
    @Size(min = 7, max = 15, message = "the phone must be between 7 and 15 characters")
    private String phone;
    

}