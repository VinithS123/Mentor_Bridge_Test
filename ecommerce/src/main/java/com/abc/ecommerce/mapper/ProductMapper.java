package com.abc.ecommerce.mapper;

import com.abc.ecommerce.dto.ProductDto;
import com.abc.ecommerce.entity.ProductEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    ProductEntity toProductEntity(ProductDto productDto);

    ProductDto toProductDto(ProductEntity productEntity);

    List<ProductDto> toProductDtoList(List<ProductEntity> productEntityList);
}
