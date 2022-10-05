package com.idpuwid.order;

import com.idpuwid.order.dto.ProductDTO;
import com.idpuwid.order.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Order {

    @Id
    private String orderId;
    private UserDTO user;
    private ProductDTO product;
    private int orderQuantity;
    private String status;
}
