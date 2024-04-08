package com.tinqin.accountingproject.rest.core.invoice.create;

import com.tinqin.accountingproject.api.invoice.create.InvoiceCreateOperation;
import com.tinqin.accountingproject.api.invoice.create.InvoiceCreateRequest;
import com.tinqin.accountingproject.api.invoice.create.InvoiceCreateResponse;
import com.tinqin.accountingproject.api.invoice.create.InvoiceCreateResponseError;
import com.tinqin.accountingproject.persistence.entity.Invoice;
import com.tinqin.accountingproject.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceCreateOperationProcessor implements InvoiceCreateOperation {

    private final InvoiceRepository invoiceRepository;


    @Override
    public InvoiceCreateResponse process(InvoiceCreateRequest operationInput) {

        List<Invoice> invoiceList = invoiceRepository.findAll();
        String testString = "";


        for (Invoice invoice : invoiceList) {
            if (operationInput.getInvoiceNumber().equalsIgnoreCase(invoice.getInvoiceId())) {
                return new InvoiceCreateResponseError("Invoice number "+operationInput.getInvoiceNumber()+
                                                                                    " already exists in the database");
            }
        }

        Invoice invoice = Invoice.builder()
                .invoiceId(operationInput.getInvoiceNumber())
                .creatorProviderId(operationInput.getCreatorProviderId())
                .creatorProviderIBAN(operationInput.getCreatorProviderIBAN())
                .receiverProviderId(operationInput.getReceiverProviderId())
                .receiverProviderIBAN(operationInput.getReceiverProviderIBAN())
                .dateOfCreation(operationInput.getDateOfCreation())
                .currency(operationInput.getCurrency())
                .sum(operationInput.getSum())
                .paymentMarker(operationInput.getPaymentMarker())
                .employee(operationInput.getEmployeeName())
                .paid(false)
                .build();

        if ("w".equalsIgnoreCase(invoice.getPaymentMarker())) {
            invoice.setDateOfPayment(Timestamp.valueOf(invoice.getDateOfCreation().toLocalDateTime().plusDays(7)));
        }

        invoiceRepository.save(invoice);

        return InvoiceCreateResponse.builder()
                .invoiceNumber(invoice.getInvoiceId())
                .creatorProviderId(invoice.getCreatorProviderId())
                .CreatorProviderIBAN(invoice.getCreatorProviderIBAN())
                .ReceiverProviderId(invoice.getReceiverProviderId())
                .ReceiverProviderIBAN(invoice.getReceiverProviderIBAN())
                .dateOfCreation(invoice.getDateOfCreation())
                .sum(invoice.getSum())
                .currency(invoice.getCurrency())
                .paymentMarker(invoice.getPaymentMarker())
                .dateOfPayment(invoice.getDateOfPayment())
                .EmployeeName(invoice.getEmployee())
                .paid(invoice.isPaid())
                .build();
    }
}
