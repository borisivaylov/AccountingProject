package com.tinqin.accountingproject.api.base;

import java.util.List;

public interface OperationListProcessor <I extends OperationInput, T extends OperationResult>{
    List<T> process(I operationInput);
}
