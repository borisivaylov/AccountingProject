package com.tinqin.accountingproject.api.base;

public interface OperationProcessor <I extends  OperationInput, P extends OperationResult>{
    P process (I operationInput);
}
