package com.tinqin.accountingproject.rest;


import com.tinqin.accountingproject.api.invoice.GetByCreationDateRange.GetByDateRangeRequest;
import com.tinqin.accountingproject.api.invoice.GetByCreationDateRange.GetByDateRangeResponse;
import com.tinqin.accountingproject.api.invoice.GetByPaymentDate.GetByPaymentDateRequest;
import com.tinqin.accountingproject.api.invoice.GetByPaymentDate.GetByPaymentDateResponse;
import com.tinqin.accountingproject.api.invoice.create.InvoiceCreateRequest;
import com.tinqin.accountingproject.api.invoice.create.InvoiceCreateResponse;
import com.tinqin.accountingproject.api.invoice.delete.InvoiceDeleteRequest;
import com.tinqin.accountingproject.api.invoice.delete.InvoiceDeleteResponse;
import com.tinqin.accountingproject.api.invoice.getAllListPagination.GetAllInvoicesRequest;
import com.tinqin.accountingproject.api.invoice.getAllListPagination.GetAllInvoicesResponse;
import com.tinqin.accountingproject.api.invoice.getById.GetByInvoiceIdRequest;
import com.tinqin.accountingproject.api.invoice.getById.GetByInvoiceIdResponse;
import com.tinqin.accountingproject.api.invoice.update.InvoiceUpdateRequest;
import com.tinqin.accountingproject.api.invoice.update.InvoiceUpdateResponse;
import com.tinqin.accountingproject.rest.core.invoice.GetByPaymentDate.GetByPaymentDateOperationProcessor;
import com.tinqin.accountingproject.rest.core.invoice.create.InvoiceCreateOperationProcessor;
import com.tinqin.accountingproject.rest.core.invoice.delete.InvoiceDeleteOperationProcessor;
import com.tinqin.accountingproject.rest.core.invoice.getAllList.GetAllInvoicesOperationProcessor;
import com.tinqin.accountingproject.rest.core.invoice.getByCreationDateRange.GetByCreationDateRangeOperationProcessor;
import com.tinqin.accountingproject.rest.core.invoice.getById.GetByInvoiceIdOperationProcessor;
import com.tinqin.accountingproject.rest.core.invoice.update.InvoiceUpdateOperationProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.tinqin.accountingproject.api.*;
import java.util.List;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private  final InvoiceCreateOperationProcessor invoiceCreateOperationProcessor;
    private  final GetByInvoiceIdOperationProcessor getByInvoiceIdOperationProcessor;
    private final InvoiceDeleteOperationProcessor invoiceDeleteOperationProcessor;
    private final InvoiceUpdateOperationProcessor invoiceUpdateOperationProcessor;
    private final GetByCreationDateRangeOperationProcessor getByCreationDateRangeOperationProcessor;
    private final GetByPaymentDateOperationProcessor getByPaymentDateOperationProcessor;
    private final GetAllInvoicesOperationProcessor getAllInvoicesOperationProcessor;


    @PostMapping("/invoiceCreate")
    InvoiceCreateResponse newInvoice (@RequestBody InvoiceCreateRequest invoiceCreateRequest){
        return invoiceCreateOperationProcessor.process(invoiceCreateRequest);
    }
    @GetMapping("/getByInvoiceID/{invoiceId}")
    GetByInvoiceIdResponse getInvoiceById(@PathVariable String invoiceId){
        return  getByInvoiceIdOperationProcessor.process(GetByInvoiceIdRequest.builder()
                                                                            .invoiceNumber(invoiceId).build());
    }

    @PostMapping("/deleteByInvoiceID/{invoiceId}")
    InvoiceDeleteResponse deleteInvoiceById(@PathVariable String invoiceId){
        return  invoiceDeleteOperationProcessor.process(InvoiceDeleteRequest.builder()
                .invoiceNumber(invoiceId).build());
    }

    @PostMapping("/invoiceUpdate")
    InvoiceUpdateResponse updateInvoice (@RequestBody InvoiceUpdateRequest invoiceUpdateRequest){
        return invoiceUpdateOperationProcessor.process(invoiceUpdateRequest);
    }
    @PostMapping("/invoiceByDateRangeCreated")
    List<GetByDateRangeResponse> invoiceByDateCreated (@RequestBody GetByDateRangeRequest getByDateRangeRequest){
       return getByCreationDateRangeOperationProcessor.process(getByDateRangeRequest);
    }

    @PostMapping("/invoiceByPaymentDate")
    List<GetByPaymentDateResponse> invoiceByPaymentDate (@RequestBody GetByPaymentDateRequest getByPaymentDateRequest){
        return getByPaymentDateOperationProcessor.process(getByPaymentDateRequest);
    }

    @PostMapping("/AllInvoicesBy")
    List<GetAllInvoicesResponse> invoiceByPaymentDate (@RequestBody GetAllInvoicesRequest getAllInvoicesRequest){
        return getAllInvoicesOperationProcessor.process(getAllInvoicesRequest);
    }

}
