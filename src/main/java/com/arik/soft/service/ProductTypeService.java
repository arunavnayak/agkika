package com.arik.soft.service;

import com.arik.soft.service.representation.ProductTypeRepresentation;

import java.util.List;

public interface ProductTypeService {
    List<ProductTypeRepresentation> getProductTypeDetails();

    ProductTypeRepresentation saveProductType(ProductTypeRepresentation ProductTypeRepresentation);

    ProductTypeRepresentation getProductTypeById(Long id);

    void deleteProductTypeById(Long id);

    ProductTypeRepresentation updateProductType(ProductTypeRepresentation representation);
}
