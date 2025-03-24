package com.redhat.demo.bookinfo.details;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiRoute extends RouteBuilder {

    public ApiRoute(@Autowired CamelContext context) {
        super(context);
    }

    @Override
    public void configure() throws Exception {

        restConfiguration()
                .bindingMode(RestBindingMode.json)
                .bindingPackageScan("com.redhat.demo.bookinfo.details")
                .apiContextPath("/api-docs");

        
        rest().openApi().specification("details-api.json").missingOperation("ignore");
        

        

    }
}
