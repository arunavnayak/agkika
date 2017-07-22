package com.arik.soft.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Invoice {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    @Column
    @NotEmpty
    private Date createdAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "INVOICE_ID")
    private Set<InvoiceItem> invoiceItems = new HashSet<>();

    @Column
    @Enumerated(EnumType.STRING)
    @NotEmpty
    private TransactionType transactionType;

    public Long getInvoiceId() {
        return invoiceId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(Set<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
