package com.idpuwid.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer id;
    private String productName;
    private String productDesc;
    private String unitMeasure;
    private int quantity;
}
