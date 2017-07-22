package com.arik.soft.service;

import com.arik.soft.service.representation.InvoiceRepresentation;

import java.util.List;

public interface InvoiceService {
    List<InvoiceRepresentation> getInvoiceDetails();

    InvoiceRepresentation saveInvoice(InvoiceRepresentation invoiceRepresentation);

    InvoiceRepresentation getInvoiceById(Long id);

    void deleteInvoiceById(Long id);

    InvoiceRepresentation updateInvoice(InvoiceRepresentation representation);
}
