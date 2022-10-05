package com.idpuwid.product;

public record ProductResponse (
        String productName,
        String productDesc,
        String unitMeasure,
        int quantity){
}
