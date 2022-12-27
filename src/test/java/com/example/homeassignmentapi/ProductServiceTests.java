package com.example.homeassignmentapi;

import com.example.homeassignmentapi.dto.ProductDTO;
import com.example.homeassignmentapi.entity.Product;
import com.example.homeassignmentapi.exception.ProductNotfoundException;
import com.example.homeassignmentapi.mapping.ProductEntityDTOMapper;
import com.example.homeassignmentapi.repository.ProductRepository;
import com.example.homeassignmentapi.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Fail.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;


    @Spy
    private ProductEntityDTOMapper mapper = Mappers.getMapper(ProductEntityDTOMapper.class);;

    private Product product;

    private ProductDTO nonExistentProductDTO;
    private ProductDTO productDTO;

    @BeforeEach
    public void setup(){
        product = Product.builder()
                .id(1L)
                .active(true)
                .name("Playstation")
                .price(Double.valueOf(3000))
                .description("Provides a better reality")
                .build();

        nonExistentProductDTO =  ProductDTO.builder()
                .active(true)
                .name("Playstation 8")
                .price(Double.valueOf(9000))
                .description("Provides an even better reality")
                .build();

        productDTO = ProductDTO.builder().active(true)     .name("Playstation")
                .price(Double.valueOf(3000))
                .description("Provides a better reality")
                .build();
    }

    @DisplayName("JUnit test for getAllProducts method")
    @Test
    public void givenProductList_whenGetAllProducts_thenReturnProductList(){
        Product product2 = Product.builder()
                .id(2L)
                .active(true)
                .name("Phone")
                .price(Double.valueOf(4000))
                .description("Does stuff")
                .build();


        // given
        given(productRepository.findAll()).willReturn(List.of(product,product2));

        // when
        List<ProductDTO> productList = productService.getAllProducts();

        // then
        assertThat(productList).isNotNull();
        assertThat(productList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for updateProduct method")
    @Test
    public void givenProductObject_whenUpdateProduct_thenExpectNoException(){
        // given
        given(productRepository.findById(product.getId()))
                .willReturn(Optional.of(product));

        try {
            // when
            productService.updateProduct(1L, productDTO);
        } catch(Exception e) {
            // then
            fail("Should not have thrown any exception");
        }


    }

    @DisplayName("JUnit test for updateProduct method when should throwExceptions")
    @Test
    public void givenProductObjectWithoutActiveValue_whenUpdateProduct_thenExpectException(){
        // given
        given(productRepository.findById(1000L))
                .willReturn(Optional.empty());

        // when
        org.junit.jupiter.api.Assertions.assertThrows(ProductNotfoundException.class, () -> {
            productService.updateProduct(1000L, nonExistentProductDTO);
        });
        // then
        verify(productRepository, never()).save(any(Product.class));

    }
}
