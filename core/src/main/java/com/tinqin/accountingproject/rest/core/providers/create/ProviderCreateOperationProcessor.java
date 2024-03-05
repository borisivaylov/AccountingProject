package com.tinqin.accountingproject.rest.core.providers.create;

import com.tinqin.accountingproject.api.provider.create.ProviderCreateOperation;
import com.tinqin.accountingproject.api.provider.create.ProviderCreateRequest;
import com.tinqin.accountingproject.api.provider.create.ProviderCreateResponse;
import com.tinqin.accountingproject.api.provider.create.ProviderCreateResponseError;
import com.tinqin.accountingproject.persistence.entity.Provider;
import com.tinqin.accountingproject.persistence.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProviderCreateOperationProcessor implements ProviderCreateOperation {

    private final ProviderRepository providerRepository;

    @Override
    public ProviderCreateResponse process(ProviderCreateRequest operationInput) {

        List<Provider> providerList = providerRepository.findAll();

        for (Provider provider : providerList) {
            if (operationInput.getProviderId().equalsIgnoreCase(provider.getProviderId())) {
                return new ProviderCreateResponseError("Provider number "+operationInput.getProviderId()+
                        " already exists in the database");
            }
        }

        providerRepository.save(Provider.builder()
                .providerId(operationInput.getProviderId())
                .providerName(operationInput.getProviderName())
                .email(operationInput.getProviderEmail())
                .location(operationInput.getProviderLocation())
                .build());

        return ProviderCreateResponse.builder()
                .providerId(operationInput.getProviderId())
                .ProviderName(operationInput.getProviderName())
                .providerEmail(operationInput.getProviderEmail())
                .providerLocation(operationInput.getProviderLocation())
                .build();
    }
}
