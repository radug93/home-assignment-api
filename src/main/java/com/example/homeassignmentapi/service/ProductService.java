package com.example.homeassignmentapi.service;

import com.example.homeassignmentapi.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    void updateProduct(Long id , ProductDTO data);
}
