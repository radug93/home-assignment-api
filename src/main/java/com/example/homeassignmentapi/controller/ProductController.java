package com.example.homeassignmentapi.controller;

import com.example.homeassignmentapi.dto.ProductDTO;
import com.example.homeassignmentapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("product")
    private List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
}
