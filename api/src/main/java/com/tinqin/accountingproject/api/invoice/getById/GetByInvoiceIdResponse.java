package com.tinqin.accountingproject.api.invoice.getById;

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
public class GetByInvoiceIdResponse implements OperationResult {

    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;
    @JsonProperty("CreatorProviderId")
    private UUID creatorProviderId;
    @JsonProperty("ReceiverProviderId")
    private UUID ReceiverProviderId;
    @JsonProperty("Sum")
    private double sum;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("DateOfCreation")
    private Timestamp dateOfCreation;
    @JsonProperty("DateOfPaymentMarker")
    private String paymentMarker;
    @JsonProperty("DateOfPayment")
    private Timestamp dateOfPayment;
    @JsonProperty("EmployeeName")
    private String EmployeeName;
    @JsonProperty("Paid")
    private boolean paid;

}
