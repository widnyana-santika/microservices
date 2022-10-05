package com.idpuwid;

import com.idpuwid.order.Order;
import com.idpuwid.order.dto.ProductDTO;
import com.idpuwid.order.dto.UserDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Order> kafkaTemplate){
        return args -> {
            Order order = Order.builder().orderId("989793240").product(new ProductDTO()).orderQuantity(10).user(new UserDTO()).status("Paid").build();
            kafkaTemplate.send("notification", order);
        };
    }
}
