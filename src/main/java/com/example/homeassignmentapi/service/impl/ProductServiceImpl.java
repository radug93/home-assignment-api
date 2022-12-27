package com.example.homeassignmentapi.service.impl;

import com.example.homeassignmentapi.dto.ProductDTO;
import com.example.homeassignmentapi.entity.Product;
import com.example.homeassignmentapi.exception.ProductNotfoundException;
import com.example.homeassignmentapi.mapping.ProductEntityDTOMapper;
import com.example.homeassignmentapi.repository.ProductRepository;
import com.example.homeassignmentapi.service.ProductService;
import org.apache.tomcat.util.buf.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl  implements ProductService {

    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductEntityDTOMapper mapper;

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts(){
        logger.info("Fetching all products");
        List<Product> toRet = productRepository.findAll();
        return  mapper.map(toRet);
    }

    @Override
    public void updateProduct(Long id, ProductDTO data) {
        Optional<Product> targetEntity = productRepository.findById(id);
        if (!targetEntity.isPresent()) {
            logger.error(String.format("Products not found for id %s", id));
            throw new ProductNotfoundException();
        }
        logger.debug("Updating entity from DTO");
        mapper.update(targetEntity.get(), data);

    }
}
