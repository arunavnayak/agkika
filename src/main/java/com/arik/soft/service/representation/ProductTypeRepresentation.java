package com.arik.soft.service.representation;

import com.arik.soft.domain.ProductType;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ProductTypeRepresentation {
    private Long productTypeId;
    private String name;
    private String type;
    private Float taxRate;

    public ProductTypeRepresentation(ProductType productType) {
        this.productTypeId = productType.getProductTypeId();
        this.name = productType.getName();
        this.type = productType.getType();
        this.taxRate = productType.getTaxRate();
    }

    public static ProductType getProductType(ProductTypeRepresentation representation){
        ProductType productType = new ProductType();
        productType.setName(representation.getName());
        productType.setType(representation.getType());
        productType.setTaxRate(representation.getTaxRate());
        return productType;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
