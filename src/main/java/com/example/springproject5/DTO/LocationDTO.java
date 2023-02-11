package com.example.springproject5.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationDTO {
    @NotNull
    private Integer store_id;

    @NotEmpty
    private String street;
    @NotEmpty
    private String area;


}
