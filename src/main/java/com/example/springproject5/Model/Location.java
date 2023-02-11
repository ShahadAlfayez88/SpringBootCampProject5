package com.example.springproject5.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Location {
    @Id
    @NotNull(message = "Store Id filed is required")
    private Integer id;
    @NotEmpty(message = "Street filed is required")
    private String street;
    @NotEmpty(message = "area filed is required")
    private String area;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Store store;
}
