package com.example.homeassignmentapi.service;

import com.example.homeassignmentapi.dto.ProductDTO;
import com.example.homeassignmentapi.entity.Product;
import com.example.homeassignmentapi.mapping.ProductEntityDTOMapper;
import com.example.homeassignmentapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductEntityDTOMapper mapper;

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        List<Product> toRet = productRepository.findAll();
        System.out.println(toRet.get(0).getCode());
        return  mapper.map(toRet);
    }
}
