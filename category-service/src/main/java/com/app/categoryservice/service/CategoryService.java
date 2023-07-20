package com.app.categoryservice.service;

import com.app.categoryservice.entity.Category;
import com.app.categoryservice.exception.MessageNotFoundException;
import com.app.categoryservice.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category){
        log.info("request category = {} ", category);
        category.setDeleted(0);
        category.setCreatedAt(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    public Category get(Long id){
        log.info("request get category by id = {}",id);
        return categoryRepository.findById(id)
                .map(data -> Category.builder()
                        .id(data.getId())
                        .name(data.getName())
                        .createdAt(data.getCreatedAt())
                        .updatedAt(data.getUpdatedAt())
                        .deleted(data.getDeleted())
                        .build())
                .orElseThrow(() -> new MessageNotFoundException("category id not found"));
    }

    public Category delete(Long id){
        log.info("request delete category = {}",id);
        return categoryRepository.findById(id)
                .map(data -> {
                    data.setDeleted(1);
                    return save(data);
                }).orElseThrow(() -> new MessageNotFoundException("failed delete because id not found"));
    }

    public Page<Category> list(Pageable pageable){
        log.info("request list category");
        return categoryRepository.findAll(pageable)
                .map(data -> Category
                        .builder()
                        .id(data.getId())
                        .name(data.getName())
                        .deleted(data.getDeleted())
                        .createdAt(data.getCreatedAt())
                        .updatedAt(data.getUpdatedAt())
                        .build());
    }
}
