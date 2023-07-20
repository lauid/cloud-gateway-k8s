package com.app.productservice.controller;

import com.app.productservice.model.request.ProductRequest;
import com.app.productservice.model.response.ProductResponse;
import com.app.productservice.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${spring.application.name}")
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @PostMapping(value = "${controller.api.create}")
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request){
        return ResponseEntity.status(HttpStatus.OK)
                .body(productsService.create(request));
    }

    @GetMapping(value = "${controller.api.list}")
    public ResponseEntity<Page<ProductResponse>> findAll(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK)
                .body(productsService.list(pageable));
    }

    @GetMapping(value = "${controller.api.get}")
    public ResponseEntity<ProductResponse> find(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(productsService.find(id));
    }
}
