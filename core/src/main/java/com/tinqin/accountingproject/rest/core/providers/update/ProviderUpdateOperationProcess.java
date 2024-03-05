package com.tinqin.accountingproject.rest.core.providers.update;

import com.tinqin.accountingproject.api.provider.update.UpdateProviderOperation;
import com.tinqin.accountingproject.api.provider.update.UpdateProviderRequest;
import com.tinqin.accountingproject.api.provider.update.UpdateProviderResponse;
import com.tinqin.accountingproject.persistence.entity.Provider;
import com.tinqin.accountingproject.persistence.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProviderUpdateOperationProcess implements UpdateProviderOperation {

    private final ProviderRepository providerRepository;

    @Override
    public UpdateProviderResponse process(UpdateProviderRequest operationInput) {

        Provider provider = providerRepository.findProviderByProviderId(operationInput.getProviderId())
                .orElseThrow(()-> new NoSuchElementException("There is no provider with id: " + operationInput.getProviderId()));

        provider.setProviderId(operationInput.getProviderId());
        provider.setProviderName(operationInput.getProviderName());
        provider.setEmail(operationInput.getProviderEmail());
        provider.setLocation(operationInput.getProviderLocation());

        return UpdateProviderResponse.builder()
                .providerId(provider.getProviderId())
                .ProviderName(provider.getProviderName())
                .providerEmail(provider.getEmail())
                .providerLocation(provider.getLocation())
                .status("Success")
                .build();
    }
}
