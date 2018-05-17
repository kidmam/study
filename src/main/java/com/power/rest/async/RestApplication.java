package com.power.rest.async;

import io.netty.channel.nio.NioEventLoopGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class RestApplication {

    @RestController
    public static class MyController {
        //RestTemplate rt = new RestTemplate();
        AsyncRestTemplate rt = new AsyncRestTemplate( new Netty4ClientHttpRequestFactory(new NioEventLoopGroup(1)));

        //WebClient


        /*@GetMapping("/rest")
        public String rest(int idx) {
            String res = rt.getForObject("http://localhost:8081/service?req={req}", String.class, "Hello" + idx);
            return res;
        }*/

        @GetMapping("/rest")
        public ListenableFuture<ResponseEntity<String>> rest(int idx) {
            return rt.getForEntity("http://localhost:8081/service?req={req}", String.class, "Hello" + idx);
        }

    }
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }
}
