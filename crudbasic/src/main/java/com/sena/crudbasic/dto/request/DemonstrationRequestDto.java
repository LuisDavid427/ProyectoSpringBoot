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
public class DemonstrationRequestDto {
    
    private int idDemonstration;
    @NotBlank(message = "the name of the demonstration is required")
    @Size(min = 2, max = 50, message = "the name of the demonstration must be between 2 and 50 characters")
    private String name;
    @NotBlank(message = "the description is required")
    @Size(min = 5, max = 200, message = "the description must be between 5 and 200 characters")
    private String description;

}