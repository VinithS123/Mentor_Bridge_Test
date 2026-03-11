package com.abc.ecommerce.controller;

import com.abc.ecommerce.dto.ProductDto;
import com.abc.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    final ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto){
        System.out.println(productDto);
        return ResponseEntity.ok(productService.addProduct(productDto));
    }

    @GetMapping("/products")
    public  ResponseEntity<List<ProductDto>> getAllProduct(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size){

        return ResponseEntity.ok(productService.getAllProduct(page,size));
    }
}
