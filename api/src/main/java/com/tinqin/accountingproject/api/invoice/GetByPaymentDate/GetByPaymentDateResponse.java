package com.tinqin.accountingproject.api.invoice.GetByPaymentDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.tinqin.accountingproject.api.base.OperationResult;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetByPaymentDateResponse implements OperationResult {
    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;
    @JsonProperty("CreatorProviderId")
    private UUID creatorProviderId;
    @JsonProperty("ReceiverProviderId")
    private UUID ReceiverProviderId;
    @JsonProperty("DateOfCreation")
    private Timestamp dateOfCreation;
    @JsonProperty("Sum")
    private double sum;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("DateOfPayment")
    private Timestamp dateOfPayment;
    @JsonProperty("Paid")
    private boolean paid;
}
