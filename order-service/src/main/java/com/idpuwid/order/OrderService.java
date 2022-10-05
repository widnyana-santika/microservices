package com.idpuwid.order;

import com.idpuwid.order.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@EnableAutoConfiguration
public record OrderService(OrderRepository repository, RestTemplate restTemplate) {

    public List<Order> getOrders(){
        return repository.findAll();
    }

    public void createOrder(Order order) {
        // todo: check if quantity exists
        ProductDTO response = restTemplate.getForObject(
                "http://PRODUCT:8084/api/v1/products/{productId}",
                ProductDTO.class,
                order.getProduct().getId()
        );
        log.info("Getting Product quantity...");

        // todo: Update quantity of product
        Map<String,String> params = new HashMap<String,String>();
        params.put("productId", "1");

        ProductDTO request = order.getProduct();
        request.setQuantity(request.getQuantity() - order.getOrderQuantity());
        restTemplate.put(
                "http://PRODUCT:8084/api/v1/products/update/{productId}",
                request,
                params
        );
        log.info("Updating product quantity...");

        // todo: Save order
        order.setProduct(request);
        repository.insert(order);

        // todo: Send notifications
    }
}
