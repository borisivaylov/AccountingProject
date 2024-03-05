package com.tinqin.accountingproject.rest;

import com.tinqin.accountingproject.api.provider.create.ProviderCreateRequest;
import com.tinqin.accountingproject.api.provider.create.ProviderCreateResponse;
import com.tinqin.accountingproject.api.provider.delete.ProviderDeleteRequest;
import com.tinqin.accountingproject.api.provider.delete.ProviderDeleteResponse;
import com.tinqin.accountingproject.api.provider.getById.GetProviderByIdRequest;
import com.tinqin.accountingproject.api.provider.getById.GetProviderByIdResponse;
import com.tinqin.accountingproject.api.provider.update.UpdateProviderRequest;
import com.tinqin.accountingproject.api.provider.update.UpdateProviderResponse;
import com.tinqin.accountingproject.rest.core.providers.create.ProviderCreateOperationProcessor;
import com.tinqin.accountingproject.rest.core.providers.delete.ProviderDeleteOperationProcessor;
import com.tinqin.accountingproject.rest.core.providers.getById.GetProviderByIdOperationProcess;
import com.tinqin.accountingproject.rest.core.providers.update.ProviderUpdateOperationProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/provider")
@RequiredArgsConstructor
public class ProviderController {

            private final ProviderCreateOperationProcessor providerCreateOperationProcessor;
            private final ProviderDeleteOperationProcessor providerDeleteOperationProcessor;
            private final GetProviderByIdOperationProcess getProviderByIdOperationProcess;
            private final ProviderUpdateOperationProcess providerUpdateOperationProcess;


    @PostMapping("/create")
    ProviderCreateResponse createProvider(@RequestBody ProviderCreateRequest providerCreateRequest){
            return  providerCreateOperationProcessor.process(providerCreateRequest);
    }
    @PostMapping("/update")
    UpdateProviderResponse updateProvider(@RequestBody UpdateProviderRequest providerUpdateRequest){
        return  providerUpdateOperationProcess.process(providerUpdateRequest);
    }
    @PostMapping("/delete")
    ProviderDeleteResponse createProvider(@RequestBody ProviderDeleteRequest providerDeleteRequest){
        return  providerDeleteOperationProcessor.process(providerDeleteRequest);
    }
    @PostMapping("/{string}")
    GetProviderByIdResponse getProviderById(@PathVariable String string){
        return  getProviderByIdOperationProcess.process(GetProviderByIdRequest.builder().providerId(string).build());
    }

}
