package edu.jdc.swll.berld.Berld.model.mappers;

import edu.jdc.swll.berld.Berld.model.dtos.ProductDTO;
import edu.jdc.swll.berld.Berld.model.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO mapFromEntity(Product product);
}

