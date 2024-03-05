package com.tinqin.accountingproject.api.provider.update;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.tinqin.accountingproject.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProviderRequest implements OperationInput {
    @JsonProperty("providerId")
    private String providerId;
    @JsonProperty("providerName")
    private String ProviderName;
    @JsonProperty("providerEmail")
    private String providerEmail;
    @JsonProperty("providerLocation")
    private String providerLocation;
}
