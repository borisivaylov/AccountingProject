package com.tinqin.accountingproject.rest.core.invoice.update;

import com.tinqin.accountingproject.api.invoice.update.InvoiceUpdateOperation;
import com.tinqin.accountingproject.api.invoice.update.InvoiceUpdateRequest;
import com.tinqin.accountingproject.api.invoice.update.InvoiceUpdateResponse;
import com.tinqin.accountingproject.persistence.entity.Invoice;
import com.tinqin.accountingproject.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class InvoiceUpdateOperationProcessor implements InvoiceUpdateOperation {
    private final InvoiceRepository invoiceRepository;

    @Override
    public InvoiceUpdateResponse process(InvoiceUpdateRequest operationInput) {

        Invoice invoice = invoiceRepository.findByInvoiceId(operationInput.getInvoiceNumber())
                .orElseThrow(()-> new NoSuchElementException("There is no such invoice"));

        invoice.setCreatorProviderId(operationInput.getCreatorProviderId());
        invoice.setReceiverProviderId(operationInput.getReceiverProviderId());
        invoice.setSum(operationInput.getSum());
        invoice.setCurrency(operationInput.getCurrency());
        invoice.setDateOfCreation(operationInput.getDateOfCreation());
        invoice.setPaymentMarker(operationInput.getPaymentMarker());
        invoice.setDateOfPayment(operationInput.getDateOfPayment());
        invoice.setEmployee(operationInput.getEmployeeName());
        invoice.setPaid(operationInput.isPaid());

        invoiceRepository.save(invoice);

        return InvoiceUpdateResponse.builder()
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
