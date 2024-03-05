package com.tinqin.accountingproject.rest.core.providers.getById;

import com.tinqin.accountingproject.api.provider.getById.GetProviderByIdOperation;
import com.tinqin.accountingproject.api.provider.getById.GetProviderByIdRequest;
import com.tinqin.accountingproject.api.provider.getById.GetProviderByIdResponse;
import com.tinqin.accountingproject.persistence.entity.Provider;
import com.tinqin.accountingproject.persistence.repository.ProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GetProviderByIdOperationProcess implements GetProviderByIdOperation {

    private final ProviderRepository providerRepository;

    @Override
    public GetProviderByIdResponse process(GetProviderByIdRequest operationInput) {


            Provider provider = providerRepository.findProviderByProviderId(operationInput.getProviderId())
                    .orElseThrow(()-> new NoSuchElementException("There is no such invoice"));

            return GetProviderByIdResponse.builder()
                    .providerId(provider.getProviderId())
                    .ProviderName(provider.getProviderId())
                    .providerEmail(provider.getEmail())
                    .providerLocation(provider.getLocation())
                    .build();
        }
    }

