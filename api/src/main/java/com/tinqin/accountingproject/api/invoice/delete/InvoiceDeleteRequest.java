package com.tinqin.accountingproject.api.invoice.delete;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.tinqin.accountingproject.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDeleteRequest implements OperationInput {
    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;
}
