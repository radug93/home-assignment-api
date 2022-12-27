package com.example.homeassignmentapi.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    private String name;
    private String description;

    private Double price;

    private String imageUrl;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @CreatedDate
    private Date creationDate;

    @LastModifiedDate
    private Date lastUpdateDate;

}