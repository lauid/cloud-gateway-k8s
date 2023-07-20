package com.app.productservice.client.service;

import com.alibaba.fastjson.JSONObject;
import com.app.productservice.client.feign.CategoryFeign;
import com.app.productservice.client.model.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryService {

    @Autowired
    private CategoryFeign categoryFeign;

    public Category getCategory(Long id){
        log.info("request category by id = {} ",id);
        return JSONObject.parseObject(categoryFeign.getCategory(id).getBody(),
                Category.class);
    }
}
