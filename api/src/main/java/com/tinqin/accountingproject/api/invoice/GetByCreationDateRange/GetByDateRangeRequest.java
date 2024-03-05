package com.tinqin.accountingproject.api.invoice.GetByCreationDateRange;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.tinqin.accountingproject.api.base.OperationInput;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetByDateRangeRequest implements OperationInput {

    @JsonProperty("fromDate")
    private Timestamp fromDate;
    @JsonProperty("toDate")
    private Timestamp toDate;

}
