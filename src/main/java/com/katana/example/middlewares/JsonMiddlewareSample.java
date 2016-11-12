package com.katana.example.middlewares;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.katana.api.Error;
import com.katana.api.common.Response;
import com.katana.api.common.Transport;
import com.katana.sdk.common.Callable;
import com.katana.sdk.common.Logger;
import com.katana.sdk.components.Middleware;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juan on 27/08/16.
 */
public class JsonMiddlewareSample {

    public static void main(String[] args) {
        Callable<Response> callable = new Callable<Response>() {
            @Override
            public Response run(Response response) {
//                // logic ...
                response.getHttpResponse().setHeader("Content-Type", "application/json");
                Transport transport = response.getTransport();
                List<Error> errors = new ArrayList<>();
                Logger.log(response.getHttpResponse().getStatusCode() + "");
                if (response.getHttpResponse().getStatusCode() > 500) {
                    Logger.log("if response.getStatusCode");
                    Error error = new Error();
                    error.setCode(response.getHttpResponse().getStatusCode());
                    error.setMessage(response.getHttpResponse().getBody());
                    errors.add(error);
                } else {
                    Logger.log("else response.getStatudCode");
                    errors = transport.getErrors();
                }
                if (errors != null) {
                    Logger.log("if errors != null");
                    response.getHttpResponse().setBody(errors.toString());
                } else {
                    Logger.log("else errors != null");
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        response.getHttpResponse().setBody(transport.getData() == null ? "" : mapper.writeValueAsString(transport.getData()));
                    } catch (JsonProcessingException e) {
                        Logger.log(e);
                    }
                }
                Logger.log(response.toString());
                return response;
            }
        };

        Middleware middleware = new Middleware(args);
        middleware.response(callable);
    }
}