package com.example.homeassignmentapi.controller;

import com.example.homeassignmentapi.dto.ProductDTO;
import com.example.homeassignmentapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @Valid @RequestBody ProductDTO product) {
        // Not needed, just to proof Java11 functionalities
        productService.checkIfCodeIsBlank(product);

        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }

    @GetMapping
    private List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
}
