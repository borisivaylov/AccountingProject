package com.tinqin.accountingproject.rest.core.invoice.delete;

import com.tinqin.accountingproject.api.invoice.delete.InvoiceDeleteOperation;
import com.tinqin.accountingproject.api.invoice.delete.InvoiceDeleteRequest;
import com.tinqin.accountingproject.api.invoice.delete.InvoiceDeleteResponse;
import com.tinqin.accountingproject.persistence.entity.Invoice;
import com.tinqin.accountingproject.persistence.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceDeleteOperationProcessor implements InvoiceDeleteOperation {

    private  final  InvoiceRepository invoiceRepository;
    @Override
    public InvoiceDeleteResponse process(InvoiceDeleteRequest operationInput) {

        List<Invoice> invoiceList = invoiceRepository.findAll();
        boolean invoiceExists = false;

        for (Invoice invoice : invoiceList) {
            if (invoiceRepository.findByInvoiceId(operationInput.getInvoiceNumber()).isPresent()) {

                Invoice foundInvoice = invoiceRepository.findByInvoiceId(operationInput.getInvoiceNumber()).orElseThrow(()->
                        new IllegalArgumentException("No invoice with invoice number:"+operationInput.getInvoiceNumber()));

                foundInvoice.setSum(0);
                invoiceRepository.save(foundInvoice);

                return InvoiceDeleteResponse.builder()
                        .operationStatus("Invoice with number "+operationInput.getInvoiceNumber()+" was successfully cancelled")
                        .build();
            }
        }


        return InvoiceDeleteResponse.builder()
                .operationStatus("Invoice with number "+operationInput.getInvoiceNumber()+" doesnt't exist.")
                .build();
    }
}
