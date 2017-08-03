package com.arik.soft.service;

import com.arik.soft.domain.ProductRepository;
import com.arik.soft.service.representation.ProductRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository ProductRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductRepresentation> getProductDetails() {
        return StreamSupport
                .stream(ProductRepository.findAll().spliterator(), false)
                .map(ProductRepresentation::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductRepresentation saveProduct(ProductRepresentation ProductData) {
        return new ProductRepresentation(
                ProductRepository.save(ProductRepresentation.getProduct(ProductData))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public ProductRepresentation getProductById(Long ProductId) {
        return new ProductRepresentation(ProductRepository.findOne(ProductId));
    }

    @Override
    @Transactional
    public void deleteProductById(Long ProductId) {
        ProductRepository.delete(ProductId);
    }

    @Override
    @Transactional
    public ProductRepresentation updateProduct(ProductRepresentation ProductData) {
        return new ProductRepresentation(
                ProductRepository.save(ProductRepresentation.getProduct(ProductData))
        );
    }
}
