package com.tinqin.accountingproject.rest.core.invoice.getByCreationDateRange;

import com.tinqin.accountingproject.api.invoice.GetByCreationDateRange.GetByDateRangeOperation;
import com.tinqin.accountingproject.api.invoice.GetByCreationDateRange.GetByDateRangeRequest;
import com.tinqin.accountingproject.api.invoice.GetByCreationDateRange.GetByDateRangeResponse;
import com.tinqin.accountingproject.persistence.entity.Invoice;
import com.tinqin.accountingproject.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GetByCreationDateRangeOperationProcessor implements GetByDateRangeOperation {

    private final InvoiceRepository invoiceRepository;
    @Override
    public List<GetByDateRangeResponse> process(GetByDateRangeRequest operationInput) {

        List<Invoice> invoices = invoiceRepository.findAllByDateOfCreationBetween
                                    (operationInput.getFromDate(),operationInput.getToDate());

        List<GetByDateRangeResponse> invoicesBydateRangeResponseList = new ArrayList<>();

        if (invoices.isEmpty()){
            throw  new NoSuchElementException("There are no invoices created in this period.");
        }

        for (Invoice invoice: invoices) {

            invoicesBydateRangeResponseList.add(GetByDateRangeResponse.builder()
                            .invoiceNumber(invoice.getInvoiceId())
                            .creatorProviderId(invoice.getCreatorProviderId())
                            .ReceiverProviderId(invoice.getReceiverProviderId())
                            .dateOfCreation(invoice.getDateOfCreation())
                            .sum(invoice.getSum())
                            .currency(invoice.getCurrency())
                            .dateOfPayment(invoice.getDateOfPayment())
                            .paid(invoice.isPaid())
                            .build());
        }

        return invoicesBydateRangeResponseList;
    }
}
