package com.tinqin.accountingproject.api.provider.create;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.tinqin.accountingproject.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProviderCreateResponse implements OperationResult {
    @JsonProperty("providerId")
    private String providerId;
    @JsonProperty("providerName")
    private String ProviderName;
    @JsonProperty("providerEmail")
    private String providerEmail;
    @JsonProperty("providerLocation")
    private String providerLocation;
    @JsonProperty("status")
    private String status;
}
