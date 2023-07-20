package com.app.categoryservice.controller;

import com.app.categoryservice.entity.Category;
import com.app.categoryservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${spring.application.name}")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "${controller.api.create}")
    public ResponseEntity<Category> save(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryService.save(category));
    }

    @PostMapping(value = "${controller.api.delete}/{id}")
    public ResponseEntity<Category> delete(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryService.delete(id));
    }

    @GetMapping(value = "${controller.api.list}")
    public ResponseEntity<Page<Category>> list(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryService.list(pageable));
    }

    @GetMapping(value = "${controller.api.get}")
    public ResponseEntity<Category> find(@PathVariable("id")Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryService.get(id));
    }
}
