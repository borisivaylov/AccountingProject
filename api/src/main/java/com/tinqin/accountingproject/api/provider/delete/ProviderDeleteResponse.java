package com.tinqin.accountingproject.api.provider.delete;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.tinqin.accountingproject.api.base.OperationResult;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDeleteResponse implements OperationResult {
    @JsonProperty("status")
    private String status;
}
