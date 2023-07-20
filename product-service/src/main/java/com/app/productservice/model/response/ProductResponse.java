package com.app.productservice.model.response;

import com.app.productservice.client.model.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("category")
    private Category category;
    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("qty")
    private Integer qty;

    @JsonProperty("image")
    private String image;

    @JsonProperty("created_at")
    private String createdAt;

}
