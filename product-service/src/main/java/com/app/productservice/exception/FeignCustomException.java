package com.app.productservice.exception;

import com.app.productservice.model.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import static com.app.productservice.constant.ConstantValue.*;

@Slf4j
public class FeignCustomException implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
       log.info("request url = {} ",response.request().url());
       log.info("request header = {} ",response.request().headers());
       try{
           ObjectMapper mapper = new ObjectMapper();
           ErrorResponse errorResponse = mapper.readValue(response.body().asInputStream(), ErrorResponse.class);
           log.info("error response = {} and status = {} ",errorResponse.getErrorMessage(), errorResponse.getErrorStatus());
           return new ErrorFromClientException(errorResponse.getErrorMessage(), errorResponse.getErrorStatus());
       }catch (IOException e){
           log.error("error IOException feign decode = {} ",e.getMessage());
           throw new ErrorFromClientException(INTERNAL_SERVER_ERROR_MESSAGE, INTERNAL_SERVER_ERROR_STATUS);
       }
    }
}
