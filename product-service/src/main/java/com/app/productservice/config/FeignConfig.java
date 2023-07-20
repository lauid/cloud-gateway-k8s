package com.app.productservice.config;

import com.app.productservice.exception.FeignCustomException;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FeignConfig {

    @Bean
    ErrorDecoder errorDecoder(){
        log.info("initialize bean error decoder feign client..");
        return new FeignCustomException();
    }
}
