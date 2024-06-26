package com.tinqin.accountingproject.api.invoice.create;

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
public class InvoiceCreateResponse implements OperationResult {

    @JsonProperty("InvoiceNumber")
    private String invoiceNumber;
    @JsonProperty("CreatorProviderId")
    private UUID creatorProviderId;
    @JsonProperty("CreatorProviderIBAN")
    private String CreatorProviderIBAN;
    @JsonProperty("ReceiverProviderId")
    private UUID ReceiverProviderId;
    @JsonProperty("ReceiverProviderIBAN")
    private String ReceiverProviderIBAN;
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
