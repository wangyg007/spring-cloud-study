package com.kone.serverdemoi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
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


    /**
     * egg. 基于类配置，也可基于配置文件
     * 在上面的代码中，我们使用了另外一个router，该router使用host去断言请求是否进入该路由，当请求的host有“*.hystrix.com”，
     * 都会进入该router，该router中有一个hystrix的filter,该filter可以配置名称、和指向性fallback的逻辑的地址，
     * 比如本案例中重定向到了“/fallback”。
     * @param builder
     * @return
     */
//    @Bean
//    public RouteLocator testRoutes(RouteLocatorBuilder builder){
//        return builder.routes()
//                .route(p->p
//                        .path("/get")
//                        .filters(f->f.addRequestHeader("token","helloworld"))
//                        .uri("https://www.baidu.com/"))
//                .route(
//                        p->p
//                                .host("*.hystrix.com")
//                                .filters(f->f
//                                        .hystrix(config -> config
//                                                .setName("mycmd")
//                                                .setFallbackUri("foward:/fallback")))
//                                .uri("http://httpbin.org:80")
//                )
//                .build();
//    }

//
//    /**
//     * Mono是一个Reactive stream，对外输出一个“fallback”字符串。
//     * @return
//     */
//    @RequestMapping("/fallback")
//    public Mono<String> fallback(){
//        return Mono.just("fallback");
//    }

}
