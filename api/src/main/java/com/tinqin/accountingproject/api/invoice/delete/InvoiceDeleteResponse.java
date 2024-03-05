package com.tinqin.accountingproject.api.invoice.delete;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.tinqin.accountingproject.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDeleteResponse implements OperationResult {
    @JsonProperty("OperationStatus")
    private String operationStatus;
}
