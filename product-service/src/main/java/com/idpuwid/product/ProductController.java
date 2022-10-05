package com.idpuwid.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path="api/v1/products")
public record ProductController(ProductService productService) {

    @PostMapping
    public void createProduct(@RequestBody ProductRequest productRequest){
        log.info("New product creation {}", productRequest);
        productService.createProduct(productRequest);
    }

    @GetMapping(path="/")
    public List<Product> getProducts(){
        log.info("Getting all products...");
        return productService.getProducts();
    }

    @GetMapping(path="/{studentId}")
    public Product getProductById(@PathVariable("productId") int productId){
        log.info("Getting product {}", productId);
        return productService.getProductById(productId);
    }

    @PutMapping(path = "/update/{productId}")
    public ProductResponse updateProduct(@PathVariable("productId") int productId, @RequestBody ProductRequest productRequest){
        log.info("Updating product {}", productRequest);
        productService.updateProduct(productId, productRequest);

        return new ProductResponse(productRequest.productName(),
                productRequest.productDesc(),
                productRequest.unitMeasure(),
                productRequest.quantity());
    }
}
