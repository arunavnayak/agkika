package com.arik.soft.service.representation;

import com.arik.soft.domain.Invoice;
import com.arik.soft.domain.TransactionType;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class InvoiceRepresentation {
    private Long invoiceId;
    private Date createdAt;
    private CustomerRepresentation customer;
    private Set<InvoiceItemRepresentation> invoiceItemRepresentations = new HashSet<>();
    private TransactionType transactionType;

    public InvoiceRepresentation(Invoice invoice) {
        this.invoiceId = invoice.getInvoiceId();
        this.createdAt = invoice.getCreatedAt();
        this.customer = new CustomerRepresentation(invoice.getCustomer());
        this.invoiceItemRepresentations = invoice.getInvoiceItems()
                .stream()
                .map(InvoiceItemRepresentation::new)
                .collect(Collectors.toSet());
        this.transactionType = invoice.getTransactionType();
    }

    public static Invoice getInvoice(InvoiceRepresentation invoiceRepresentation) {
        Invoice invoice = new Invoice();
        invoice.setCreatedAt(invoiceRepresentation.getCreatedAt());
        invoice.setCustomer(CustomerRepresentation.getCustomer(invoiceRepresentation.getCustomer()));
        invoice.setInvoiceItems(InvoiceItemRepresentation.getInvoiceItems(invoiceRepresentation.getInvoiceItemRepresentations()));
        invoice.setTransactionType(invoiceRepresentation.getTransactionType());
        return invoice;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public CustomerRepresentation getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerRepresentation customer) {
        this.customer = customer;
    }

    public Set<InvoiceItemRepresentation> getInvoiceItemRepresentations() {
        return invoiceItemRepresentations;
    }

    public void setInvoiceItemRepresentations(Set<InvoiceItemRepresentation> invoiceItemRepresentations) {
        this.invoiceItemRepresentations = invoiceItemRepresentations;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
