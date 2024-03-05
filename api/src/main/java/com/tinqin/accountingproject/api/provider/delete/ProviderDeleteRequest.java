package com.tinqin.accountingproject.api.provider.delete;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.tinqin.accountingproject.api.base.OperationInput;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDeleteRequest implements OperationInput {
    @JsonProperty("providerId")
    private String providerId;
}
