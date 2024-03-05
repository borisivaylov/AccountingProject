package com.tinqin.accountingproject.api.invoice.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvoiceCreateResponseError extends InvoiceCreateResponse {
    private String errorMessage;
}
