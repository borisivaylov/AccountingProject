package com.tinqin.accountingproject.api.invoice.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tinqin.accountingproject.api.base.OperationInput;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceCreateRequest implements OperationInput {

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
    @JsonProperty("EmployeeName")
    private String EmployeeName;

}
