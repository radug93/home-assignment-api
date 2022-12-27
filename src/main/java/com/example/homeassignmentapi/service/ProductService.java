package com.example.homeassignmentapi.service;

import com.example.homeassignmentapi.dto.ProductDTO;
import com.example.homeassignmentapi.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    void updateProduct(Long id , ProductDTO data);

    default boolean checkIfCodeIsBlank(ProductDTO obj) {
        return  checkBlankJava11(obj.getCode());
    }
    private Boolean checkBlankJava11(String code) {
        return code.isBlank();
    }
}
