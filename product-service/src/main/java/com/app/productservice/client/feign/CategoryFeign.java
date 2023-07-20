package com.app.productservice.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        url = "${feignClient.category.host}",
        name = "${feignClient.category.host}",
        contextId = "${feignClient.category.context}"
)
public interface CategoryFeign {

    @GetMapping(value = "${feignClient.category.endpoint}")
    ResponseEntity<String> getCategory(@PathVariable("id")Long id);

}
