package com.tinqin.accountingproject.rest.core.invoice.GetByPaymentDate;

import com.tinqin.accountingproject.api.invoice.GetByPaymentDate.GetByPaymentDateOperation;
import com.tinqin.accountingproject.api.invoice.GetByPaymentDate.GetByPaymentDateRequest;
import com.tinqin.accountingproject.api.invoice.GetByPaymentDate.GetByPaymentDateResponse;
import com.tinqin.accountingproject.persistence.entity.Invoice;
import com.tinqin.accountingproject.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GetByPaymentDateOperationProcessor implements GetByPaymentDateOperation {

    private final InvoiceRepository invoiceRepository;

    @Override
    public List<GetByPaymentDateResponse> process(GetByPaymentDateRequest operationInput) {

        List<Invoice> invoices = invoiceRepository.findAllByDateOfPayment(operationInput.getDateOfPayment());

        List<GetByPaymentDateResponse> invoicesByPaymentDateResponseList = new ArrayList<>();

        if (invoices.isEmpty()){
            throw  new NoSuchElementException("There are no invoices to be paid on this date.");
        }

        for (Invoice invoice: invoices) {

            invoicesByPaymentDateResponseList.add(GetByPaymentDateResponse.builder()
                    .invoiceNumber(invoice.getInvoiceId())
                    .creatorProviderId(invoice.getCreatorProviderId())
                    .ReceiverProviderId(invoice.getReceiverProviderId())
                    .ReceiverProviderIBAN(invoice.getReceiverProviderIBAN())
                    .dateOfCreation(invoice.getDateOfCreation())
                    .sum(invoice.getSum())
                    .currency(invoice.getCurrency())
                    .dateOfPayment(invoice.getDateOfPayment())
                    .paid(invoice.isPaid())
                    .build());
        }

        return invoicesByPaymentDateResponseList;

    }
}
