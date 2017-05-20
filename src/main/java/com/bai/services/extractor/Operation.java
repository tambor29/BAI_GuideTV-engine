package com.bai.services.extractor;


public enum Operation{
    SEARCH("/szukaj/?q="),
    DETAIL("");

    private final String operationType;

    Operation(final String operationType){
        this.operationType = operationType;
    }

    @Override
    public String toString(){
        return operationType;
    }
}
