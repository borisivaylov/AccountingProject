package com.tinqin.accountingproject.rest.core.invoice.getById;

import com.tinqin.accountingproject.api.invoice.getById.GetByInvoiceIdOperation;
import com.tinqin.accountingproject.api.invoice.getById.GetByInvoiceIdRequest;
import com.tinqin.accountingproject.api.invoice.getById.GetByInvoiceIdResponse;
import com.tinqin.accountingproject.persistence.entity.Invoice;
import com.tinqin.accountingproject.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GetByInvoiceIdOperationProcessor implements GetByInvoiceIdOperation {

    private final InvoiceRepository invoiceRepository;
    @Override
    public GetByInvoiceIdResponse process(GetByInvoiceIdRequest operationInput) {

        Invoice invoice = invoiceRepository.findByInvoiceId(operationInput.getInvoiceNumber())
                .orElseThrow(()-> new NoSuchElementException("There is no such invoice"));


        return GetByInvoiceIdResponse.builder()
                .invoiceNumber(invoice.getInvoiceId())
                .creatorProviderId(invoice.getCreatorProviderId())
                .ReceiverProviderId(invoice.getReceiverProviderId())
                .sum(invoice.getSum())
                .currency(invoice.getCurrency())
                .dateOfCreation(invoice.getDateOfCreation())
                .dateOfPayment(invoice.getDateOfPayment())
                .EmployeeName(invoice.getEmployee())
                .paid(invoice.isPaid())
                .build();
    }
}
