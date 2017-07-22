package com.arik.soft.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ProductType {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productTypeId;

    @Column
    @NotNull
    private String name;

    @Column
    private String type;

    @Column
    @NotEmpty
    private Float taxRate;

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
}
