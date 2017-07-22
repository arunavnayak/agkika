package com.arik.soft.service.representation;

import com.arik.soft.domain.Product;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ProductRepresentation {
    private Long productId;
    private String name;
    private Integer rate;
    private ProductTypeRepresentation productType;

    public ProductRepresentation(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.rate = product.getRate();
        this.productType = new ProductTypeRepresentation(product.getProductType());
    }

    public static Product getProduct(ProductRepresentation productRepresentation){
        Product product = new Product();
        product.setName(productRepresentation.getName());

        product.setProductType(ProductTypeRepresentation.getProductType(productRepresentation.getProductType()));
        product.setRate(productRepresentation.getRate());

        return product;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public ProductTypeRepresentation getProductType() {
        return productType;
    }

    public void setProductType(ProductTypeRepresentation productType) {
        this.productType = productType;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
