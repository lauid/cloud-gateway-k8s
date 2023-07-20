package com.app.productservice.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("qty")
    private Integer qty;

    @JsonProperty("image")
    private String image;
}
