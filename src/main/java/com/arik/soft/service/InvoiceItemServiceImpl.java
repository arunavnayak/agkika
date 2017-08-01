package com.arik.soft.service;

import com.arik.soft.domain.InvoiceItemRepository;
import com.arik.soft.service.representation.InvoiceItemRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InvoiceItemServiceImpl implements InvoiceItemService {

    @Autowired
    private InvoiceItemRepository InvoiceItemRepository;

    @Override
    @Transactional(readOnly = true)
    public List<InvoiceItemRepresentation> getInvoiceItemDetails() {
        return StreamSupport
                .stream(InvoiceItemRepository.findAll().spliterator(), false)
                .map(InvoiceItemRepresentation::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public InvoiceItemRepresentation saveInvoiceItem(InvoiceItemRepresentation invoiceItem) {
        return new InvoiceItemRepresentation(
                InvoiceItemRepository.save(InvoiceItemRepresentation.getInvoiceItem(invoiceItem))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public InvoiceItemRepresentation getInvoiceItemById(Long InvoiceItemId) {
        return new InvoiceItemRepresentation(InvoiceItemRepository.findOne(InvoiceItemId));
    }

    @Override
    @Transactional
    public void deleteInvoiceItemById(Long InvoiceItemId) {
        InvoiceItemRepository.delete(InvoiceItemId);
    }

    @Override
    @Transactional
    public InvoiceItemRepresentation updateInvoiceItem(InvoiceItemRepresentation invoiceItem) {
        return new InvoiceItemRepresentation(
                InvoiceItemRepository.save(InvoiceItemRepresentation.getInvoiceItem(invoiceItem))
        );
    }
}
