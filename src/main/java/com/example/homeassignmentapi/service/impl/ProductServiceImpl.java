package com.example.homeassignmentapi.service.impl;

import com.example.homeassignmentapi.dto.ProductDTO;
import com.example.homeassignmentapi.entity.Product;
import com.example.homeassignmentapi.exception.ProductNotfoundException;
import com.example.homeassignmentapi.mapping.ProductEntityDTOMapper;
import com.example.homeassignmentapi.repository.ProductRepository;
import com.example.homeassignmentapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductEntityDTOMapper mapper;

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        List<Product> toRet = productRepository.findAll();
        System.out.println(toRet.get(0).getCode());
        return  mapper.map(toRet);
    }

    @Override
    public void updateProduct(Long id, ProductDTO data) {
        Optional<Product> targetEntity = productRepository.findById(id);
        if(!targetEntity.isPresent()) {
            throw new ProductNotfoundException();
        }
        mapper.update(targetEntity.get(), data);
        productRepository.save(targetEntity.get());
    }
}
