package com.arik.soft.service.representation;

import com.arik.soft.domain.InvoiceItem;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class InvoiceItemRepresentation {
    private Long invoiceItemId;
    private ProductRepresentation product;
    private Integer quantiy;

    public InvoiceItemRepresentation(InvoiceItem invoiceItem) {
        this.invoiceItemId = invoiceItem.getInvoiceItemId();
        this.product = new ProductRepresentation(invoiceItem.getProduct());
        this.quantiy = invoiceItem.getQuantiy();
    }

    public static Set<InvoiceItem> getInvoiceItems(Set<InvoiceItemRepresentation> invoiceItemRepresentations){
        return StreamSupport
                .stream(invoiceItemRepresentations.spliterator(), false)
                .map( r -> InvoiceItemRepresentation.getInvoiceItem(r))
                .collect(Collectors.toSet());
    }

    public static InvoiceItem getInvoiceItem(InvoiceItemRepresentation invoiceItemRepresentation){
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setProduct(ProductRepresentation.getProduct(invoiceItemRepresentation.getProduct()));
        invoiceItem.setQuantiy(invoiceItemRepresentation.getQuantiy());
        return invoiceItem;
    }

    public Long getInvoiceItemId() {
        return invoiceItemId;
    }

    public ProductRepresentation getProduct() {
        return product;
    }

    public void setProduct(ProductRepresentation product) {
        this.product = product;
    }

    public Integer getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(Integer quantiy) {
        this.quantiy = quantiy;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
