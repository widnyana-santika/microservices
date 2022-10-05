package com.idpuwid.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/orders")
public record OrderController(OrderService service) {

    @GetMapping
    public List<Order> getOrders(){
        log.info("Fetching all orders...");
        return service.getOrders();
    }

    @PostMapping
    public void createOrder(@RequestBody Order order){
        log.info("Creating order {}", order);
        service.createOrder(order);
    }
}
