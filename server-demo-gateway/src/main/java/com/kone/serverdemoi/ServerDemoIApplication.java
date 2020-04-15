package com.kone.serverdemoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Cloud Gateway作为Spring Cloud框架的第二代网关，在功能上要比Zuul更加的强大，性能也更好。
 * 随着Spring Cloud的版本迭代，Spring Cloud官方有打算弃用Zuul的意思。
 * 在笔者调用了Spring Cloud Gateway的使用和功能上，Spring Cloud Gateway替换掉Zuul的成本上是非常低的，几乎可以无缝切换。
 * Spring Cloud Gateway几乎包含了zuul的所有功能。
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
public class ServerDemoIApplication {



    public static void main(String[] args) {
        SpringApplication.run(ServerDemoIApplication.class, args);
    }


    @Bean
    public RouteLocator testRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p->p
                        .path("/get")
                        .filters(f->f.addRequestHeader("token","helloworld"))
                        .uri("http://httpbin.org:80"))

                .build();
    }

}
