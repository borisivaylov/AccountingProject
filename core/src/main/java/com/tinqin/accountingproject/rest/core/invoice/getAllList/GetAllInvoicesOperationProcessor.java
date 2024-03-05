package com.tinqin.accountingproject.rest.core.invoice.getAllList;

import com.tinqin.accountingproject.api.invoice.getAllListPagination.GetAllInvoicesOperation;
import com.tinqin.accountingproject.api.invoice.getAllListPagination.GetAllInvoicesRequest;
import com.tinqin.accountingproject.api.invoice.getAllListPagination.GetAllInvoicesResponse;
import com.tinqin.accountingproject.persistence.entity.Invoice;
import com.tinqin.accountingproject.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GetAllInvoicesOperationProcessor implements GetAllInvoicesOperation {

    private final InvoiceRepository invoiceRepository;

    @Override
    public List<GetAllInvoicesResponse> process(GetAllInvoicesRequest operationInput) {

        List<Invoice> invoices = invoiceRepository.findAll(Sort.by("invoiceId"));
        List< GetAllInvoicesResponse> getAllInvoicesResponseList = new ArrayList<>();

        if (invoices.isEmpty()){
            throw new NoSuchElementException("There invoices don't have such a property");
        }

        for (Invoice invoice: invoices) {

            getAllInvoicesResponseList.add(GetAllInvoicesResponse.builder()
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
        return getAllInvoicesResponseList;
    }
}
