package com.tinqin.accountingproject.api.provider.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProviderCreateResponseError extends ProviderCreateResponse {
    private String errorMessage;
}
