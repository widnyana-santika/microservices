package com.idpuwid.product;

public record ProductRequest (
        String productName,
        String productDesc,
        String unitMeasure,
        int quantity){
}
