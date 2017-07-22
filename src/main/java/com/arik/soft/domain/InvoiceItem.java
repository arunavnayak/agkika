package com.arik.soft.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
public class InvoiceItem {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceItemId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column
    @NotEmpty
    private Integer quantiy;

    public Long getInvoiceItemId() {
        return invoiceItemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(Integer quantiy) {
        this.quantiy = quantiy;
    }

}
