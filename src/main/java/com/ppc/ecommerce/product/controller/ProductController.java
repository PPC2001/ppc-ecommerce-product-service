package com.ppc.ecommerce.product.controller;

import com.ppc.ecommerce.product.service.ProductService;
import com.ppc.ecommerce.sdk.dto.ApiResponse;
import com.ppc.ecommerce.sdk.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductDto>>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(ApiResponse.success(products, "Fetched all products successfully"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductDto>> getProductById(@PathVariable String id) {
        ProductDto product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.status(404).body(ApiResponse.error("Product not found with ID: " + id));
        }
        return ResponseEntity.ok(ApiResponse.success(product, "Product details retrieved"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductDto>> createProduct(@RequestBody ProductDto product) {
        ProductDto created = productService.createProduct(product);
        return ResponseEntity.status(201).body(ApiResponse.success(created, "Product created successfully"));
    }
}
