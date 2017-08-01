package com.arik.soft.service;

import com.arik.soft.domain.InvoiceRepository;
import com.arik.soft.service.representation.InvoiceRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepository InvoiceRepository;

    @Override
    @Transactional(readOnly = true)
    public List<InvoiceRepresentation> getInvoiceDetails() {
        return StreamSupport
                .stream(InvoiceRepository.findAll().spliterator(), false)
                .map(InvoiceRepresentation::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public InvoiceRepresentation saveInvoice(InvoiceRepresentation invoiceData) {
        return new InvoiceRepresentation(
                InvoiceRepository.save(InvoiceRepresentation.getInvoice(invoiceData))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public InvoiceRepresentation getInvoiceById(Long InvoiceId) {
        return new InvoiceRepresentation(InvoiceRepository.findOne(InvoiceId));
    }

    @Override
    @Transactional
    public void deleteInvoiceById(Long InvoiceId) {
        InvoiceRepository.delete(InvoiceId);
    }

    @Override
    @Transactional
    public InvoiceRepresentation updateInvoice(InvoiceRepresentation invoiceData) {
        return new InvoiceRepresentation(
                InvoiceRepository.save(InvoiceRepresentation.getInvoice(invoiceData))
        );
    }
}
