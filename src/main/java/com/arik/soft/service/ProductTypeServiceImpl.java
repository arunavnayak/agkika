package com.arik.soft.service;

import com.arik.soft.domain.ProductTypeRepository;
import com.arik.soft.service.representation.ProductTypeRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTypeServiceImpl.class);

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductTypeRepresentation> getProductTypeDetails() {
        return StreamSupport
                .stream(productTypeRepository.findAll().spliterator(), false)
                .map(ProductTypeRepresentation::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductTypeRepresentation saveProductType(ProductTypeRepresentation ProductTypeData) {
        return new ProductTypeRepresentation(
                productTypeRepository.save(ProductTypeRepresentation.getProductType(ProductTypeData))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public ProductTypeRepresentation getProductTypeById(Long ProductTypeId) {
        return new ProductTypeRepresentation(productTypeRepository.findOne(ProductTypeId));
    }

    @Override
    @Transactional
    public void deleteProductTypeById(Long ProductTypeId) {
        productTypeRepository.delete(ProductTypeId);
    }

    @Override
    @Transactional
    public ProductTypeRepresentation updateProductType(ProductTypeRepresentation ProductTypeData) {
        return new ProductTypeRepresentation(
                productTypeRepository.save(ProductTypeRepresentation.getProductType(ProductTypeData))
        );
    }
}
