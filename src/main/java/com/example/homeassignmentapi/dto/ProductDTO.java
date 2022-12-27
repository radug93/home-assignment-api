package com.example.homeassignmentapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private String code;

    private String description;

    private Double price;

    private String imageUrl;

    private Boolean active;
}
