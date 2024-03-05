package com.tinqin.accountingproject.api.invoice.GetByProviderRegex;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.tinqin.accountingproject.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetByProviderRegexRequest implements OperationInput {
    @JsonProperty("providerName")
    private String providerName;

}
