package com.abc.ecommerce.mapper;

import com.abc.ecommerce.dto.ProductDto;
import com.abc.ecommerce.entity.ProductEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-11T21:45:56+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductEntity toProductEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setProductId( productDto.getProductId() );
        productEntity.setProductName( productDto.getProductName() );
        productEntity.setPrice( productDto.getPrice() );
        productEntity.setDescription( productDto.getDescription() );

        return productEntity;
    }

    @Override
    public ProductDto toProductDto(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductId( productEntity.getProductId() );
        productDto.setProductName( productEntity.getProductName() );
        productDto.setPrice( productEntity.getPrice() );
        productDto.setDescription( productEntity.getDescription() );

        return productDto;
    }

    @Override
    public List<ProductDto> toProductDtoList(List<ProductEntity> productEntityList) {
        if ( productEntityList == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( productEntityList.size() );
        for ( ProductEntity productEntity : productEntityList ) {
            list.add( toProductDto( productEntity ) );
        }

        return list;
    }
}
