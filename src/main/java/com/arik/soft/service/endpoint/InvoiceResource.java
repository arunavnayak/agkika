package com.arik.soft.service.endpoint;

import com.arik.soft.domain.Invoice;
import com.arik.soft.service.InvoiceService;
import com.arik.soft.service.representation.InvoiceRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/invoice")
public class InvoiceResource {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public ResponseEntity InvoiceDetails() {
        return new ResponseEntity(invoiceService.getInvoiceDetails(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getInvoiceDetails(@PathVariable final Long id) {
        return new ResponseEntity(invoiceService.getInvoiceById(id), HttpStatus.OK);
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity addNewInvoice(@NotNull @RequestBody final InvoiceRepresentation InvoiceRepresentation) {
        Invoice Invoice = InvoiceRepresentation.getInvoice(InvoiceRepresentation);

        return new ResponseEntity(
                invoiceService.saveInvoice(new InvoiceRepresentation(Invoice)), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteInvoiceDetails(@PathVariable final Long id) {
        invoiceService.deleteInvoiceById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity updateInvoiceDetails(
            @NotNull @RequestBody final InvoiceRepresentation representation){
        invoiceService.updateInvoice(representation);
        return new ResponseEntity(HttpStatus.OK);
    }

}
