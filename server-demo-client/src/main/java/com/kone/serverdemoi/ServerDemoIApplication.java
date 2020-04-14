package com.kone.serverdemoi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RequestMapping("/hi")
public class ServerDemoIApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerDemoIApplication.class, args);
    }

    @Value("${server.port}")
    String port;


    @GetMapping("/home")
    public String home(@RequestParam String name){
        return "hi "+name+",i am from port:"+port;
    }

}
