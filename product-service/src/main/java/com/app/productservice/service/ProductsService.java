package com.app.productservice.service;

import com.alibaba.fastjson.JSON;
import com.app.productservice.client.service.CategoryService;
import com.app.productservice.entity.Products;
import com.app.productservice.exception.MessageNotfoundException;
import com.app.productservice.model.request.ProductRequest;
import com.app.productservice.model.response.ProductResponse;
import com.app.productservice.repository.ProductsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoryService categoryService;

    public ProductResponse create(ProductRequest request){
        log.info("request product = {} ", JSON.toJSON(request));
        categoryService.getCategory(request.getCategoryId());
        Products saveProduct = productsRepository.save(entityProduct(request));
        return modelProduct(saveProduct);
    }

    public Page<ProductResponse> list(Pageable pageable){
        log.info("request product = {} ",JSON.toJSON(pageable));
        return productsRepository.findAll(pageable)
                .map(data -> ProductResponse.builder()
                        .id(data.getId())
                        .name(data.getName())
                        .category(this.categoryService.getCategory(data.getCategoryId()))
                        .image(data.getImage())
                        .qty(data.getQty())
                        .createdAt(data.getCreatedAt()
                                .format(DateTimeFormatter.ISO_LOCAL_DATE))
                        .price(data.getPrice())
                        .build());
    }

    public ProductResponse find(Long id){
        log.info("request product find = {} ",id);
        return productsRepository.findById(id)
                .map(data -> modelProduct(data))
                .orElseThrow(() -> new MessageNotfoundException("product id not found"));
    }


    private Products entityProduct(ProductRequest request){
        return Products.builder()
                .name(request.getName())
                .categoryId(request.getCategoryId())
                .createdAt(LocalDateTime.now())
                .price(request.getPrice())
                .image(request.getImage())
                .qty(request.getQty())
                .build();
    }

    private ProductResponse modelProduct(Products products){
        return ProductResponse.builder()
                .id(products.getId())
                .name(products.getName())
                .price(products.getPrice())
                .image(products.getImage())
                .qty(products.getQty())
                .category(this.categoryService.getCategory(products.getCategoryId()))
                .build();
    }
}
