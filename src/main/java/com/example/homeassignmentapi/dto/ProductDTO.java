package com.example.homeassignmentapi.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Builder
public class ProductDTO implements Serializable {

    @NotEmpty
    private String code;

    private String description;

    private String name;

    private Double price;

    private String imageUrl;

    @NotNull
    private Boolean active;
}
