package com.abc.ecommerce.service;

import com.abc.ecommerce.dto.ProductDto;
import com.abc.ecommerce.entity.ProductEntity;
import com.abc.ecommerce.mapper.ProductMapper;
import com.abc.ecommerce.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductMapper productMapper;

    final ProductRepo productRepo;

    public ProductDto addProduct(ProductDto productDto) {
        System.out.println(productDto);
        ProductEntity product = productMapper.toProductEntity(productDto);
        return productMapper.toProductDto(productRepo.save(product));
    }

    public List<ProductDto> getAllProduct(int page, int size) {
        List<ProductEntity> products = productRepo.findAll(PageRequest.of(page,size)).getContent();
        return  productMapper.toProductDtoList(products);
    }
}
