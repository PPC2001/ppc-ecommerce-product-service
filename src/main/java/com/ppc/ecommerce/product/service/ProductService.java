package com.ppc.ecommerce.product.service;

import com.ppc.ecommerce.sdk.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final List<ProductDto> products = new ArrayList<>(List.of(
            ProductDto.builder().id("PROD-001").name("Wireless Noise-Canceling Headphones").description("High fidelity audio headphones").price(new BigDecimal("199.99")).stockQuantity(50).category("Electronics").build(),
            ProductDto.builder().id("PROD-002").name("Ergonomic Mechanical Keyboard").description("RGB backlight gaming keyboard").price(new BigDecimal("89.99")).stockQuantity(100).category("Electronics").build()
    ));

    public List<ProductDto> getAllProducts() {
        return products;
    }

    public ProductDto getProductById(String id) {
        return products.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public ProductDto createProduct(ProductDto product) {
        if (product.getId() == null) {
            product.setId("PROD-" + (products.size() + 1));
        }
        products.add(product);
        return product;
    }
}
