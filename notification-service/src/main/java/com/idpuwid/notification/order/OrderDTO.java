package com.idpuwid.notification.order;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String orderId;
    private UserDTO user;
    private ProductDTO product;
    private int orderQuantity;
    private String status;
}
