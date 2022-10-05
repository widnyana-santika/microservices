package com.idpuwid.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String productName;
    private String productDesc;
    private String unitMeasure;
    private int quantity;
}
