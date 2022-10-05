package com.idpuwid.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public record ProductService(ProductRepository productRepository) {
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .productName(productRequest.productName())
                .productDesc(productRequest.productDesc())
                .unitMeasure(productRequest.unitMeasure())
                .quantity(productRequest.quantity())
                .build();
        // todo: check if product name exist

        // todo: store product in database
        productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).orElseThrow(() -> new IllegalStateException("Product Not Exists"));
    }

    public void updateProduct(int id, ProductRequest productRequest) {
        Product product = getProductById(id);

        product.setProductName(productRequest.productName());
        product.setProductDesc(productRequest.productDesc());
        product.setQuantity(productRequest.quantity());
        product.setUnitMeasure(productRequest.unitMeasure());

        productRepository.save(product);
    }
}
