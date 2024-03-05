package com.tinqin.accountingproject.rest.core.providers.delete;

import com.tinqin.accountingproject.api.provider.delete.ProviderDeleteOperation;
import com.tinqin.accountingproject.api.provider.delete.ProviderDeleteRequest;
import com.tinqin.accountingproject.api.provider.delete.ProviderDeleteResponse;
import com.tinqin.accountingproject.persistence.entity.Provider;
import com.tinqin.accountingproject.persistence.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProviderDeleteOperationProcessor implements ProviderDeleteOperation {

    private final ProviderRepository providerRepository;
    @Override
    public ProviderDeleteResponse process(ProviderDeleteRequest operationInput) {

        Provider provider = providerRepository.findProviderByProviderId(operationInput.getProviderId())
                .orElseThrow(()-> new NoSuchElementException("There is no provider with id: " + operationInput.getProviderId()));

        providerRepository.delete(provider);

        return ProviderDeleteResponse.builder()
                .status("Provider with id:" + operationInput.getProviderId() + "was deleted")
                .build();
    }
}
