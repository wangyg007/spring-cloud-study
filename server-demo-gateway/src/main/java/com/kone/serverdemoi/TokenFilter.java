package com.kone.serverdemoi;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Spring Cloud Gateway同zuul类似，有“pre”和“post”两种方式的filter。客户端的请求先经过“pre”类型的filter，
 * 然后将请求转发到具体的业务服务，比如上图中的user-service，收到业务服务的响应之后，
 * 再经过“post”类型的filter处理，最后返回响应到客户端。
 *
 * Spring Cloud Gateway根据作用范围划分为GatewayFilter和GlobalFilter，
 * 二者区别如下：
 *
 * GatewayFilter : 需要通过spring.cloud.routes.filters 配置在具体路由下，
 * 只作用在当前路由上或通过spring.cloud.default-filters配置在全局，作用在所有路由上
 *
 * GlobalFilter : 全局过滤器，不需要在配置文件中配置，作用在所有的路由上，
 * 最终通过GatewayFilterAdapter包装成GatewayFilterChain可识别的过滤器，
 * 它为请求业务以及路由的URI转换为真实业务服务的请求地址的核心过滤器，不需要配置，系统初始化时加载，并作用在每个路由上。
 *
 * @author wangyg
 * @time 2020/4/16 16:43
 * @note
 **/
@Component
public class TokenFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getQueryParams().getFirst("token");
        if (StringUtils.isEmpty(token)) {
            System.out.println("token is empty!!!");

            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);

            /**https 返回跨域时可能要设置返回头**/
            //response.getHeaders().add("k","v");

            return response.setComplete();

        }

        return chain.filter(exchange);
    }

    /**
     * getOrder()方法是来给过滤器设定优先级别的，值越大则优先级越低
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
