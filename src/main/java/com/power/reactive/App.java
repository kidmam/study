package com.power.reactive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@Slf4j
public class App {

    static final String URL1 = "http://localhost:8081/service?req={req}";
    static final String URL2 = "http://localhost:8081/service?req={req}";

    @Autowired
    MyService myService;

    WebClient clinet = WebClient.create();
    @GetMapping("/rest")
    public Mono<String> rest(int idx) {
        Mono<ClientResponse> res = clinet.get().uri(URL1, idx).exchange(); //선언만하면 실행되지 않음.
        Mono<String> body = res.flatMap(clientResponse -> clientResponse.bodyToMono(String.class));
        //return Mono.just("Hello");
        return body;
    }

    public static void main(String[] args) {
        System.setProperty("reactor.ipc.netty.workerCount", "2");
        System.setProperty("reactor.ipc.netty.pool.maxConnections", "2000");
        SpringApplication.run(App.class, args);
    }

    @Service
    public static class MyService {
        public String work(String req) {
            return req + "Async";
        }
    }
}
