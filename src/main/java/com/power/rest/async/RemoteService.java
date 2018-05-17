package com.power.rest.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RemoteService {

    @RestController
    public static class MyController {

        @GetMapping("/service")
        public String service(String req) {
            return req + "/service";
        }

    }

    public static void main(String[] args) {
        System.setProperty("server.port", "8081"); //내장 톰캣 Override
        System.setProperty("server.tomcat.max-threads", "100");

        SpringApplication.run(RemoteService.class, args);
    }
}
