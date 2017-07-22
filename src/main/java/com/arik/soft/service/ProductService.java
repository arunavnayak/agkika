package com.arik.soft.service;

import com.arik.soft.service.representation.ProductRepresentation;

import java.util.List;

public interface ProductService {
    List<ProductRepresentation> getProductDetails();

    ProductRepresentation saveProduct(ProductRepresentation ProductRepresentation);

    ProductRepresentation getProductById(Long id);

    void deleteProductById(Long id);

    ProductRepresentation updateProduct(ProductRepresentation representation);
}
