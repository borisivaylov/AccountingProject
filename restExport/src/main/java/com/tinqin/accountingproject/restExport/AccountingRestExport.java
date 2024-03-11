package com.tinqin.accountingproject.restExport;

import com.tinqin.accountingproject.api.invoice.GetByPaymentDate.GetByPaymentDateRequest;
import com.tinqin.accountingproject.api.invoice.GetByPaymentDate.GetByPaymentDateResponse;
import com.tinqin.accountingproject.api.invoice.getById.GetByInvoiceIdRequest;
import com.tinqin.accountingproject.api.invoice.getById.GetByInvoiceIdResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Headers({"Content-Type: application/json"})
public interface AccountingRestExport {

    @RequestLine("POST /invoice/invoiceByPaymentDate")
    List<GetByPaymentDateResponse> getByPaymentDate(@RequestBody GetByPaymentDateRequest getByPaymentDateRequest);

    @RequestLine( "GET /invoice/getByInvoiceID/{invoiceId}")
    GetByInvoiceIdResponse getInvoiceById(@Param String invoiceId);

}
