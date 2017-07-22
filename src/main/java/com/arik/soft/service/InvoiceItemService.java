package com.arik.soft.service;

import com.arik.soft.service.representation.InvoiceItemRepresentation;

import java.util.List;

public interface InvoiceItemService {
    List<InvoiceItemRepresentation> getInvoiceItemDetails();

    InvoiceItemRepresentation saveInvoiceItem(InvoiceItemRepresentation InvoiceItemRepresentation);

    InvoiceItemRepresentation getInvoiceItemById(Long id);

    void deleteInvoiceItemById(Long id);

    InvoiceItemRepresentation updateInvoiceItem(InvoiceItemRepresentation representation);
}
