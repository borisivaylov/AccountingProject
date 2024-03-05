package com.tinqin.accountingproject.api.invoice.GetByPaymentDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.tinqin.accountingproject.api.base.OperationInput;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetByPaymentDateRequest implements OperationInput {
    @JsonProperty("DateOfPayment")
    private Timestamp dateOfPayment;
}
