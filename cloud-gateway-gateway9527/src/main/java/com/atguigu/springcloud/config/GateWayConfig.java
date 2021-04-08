
package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_rote_atguigu", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        routes.route("ssjf49-store-api-web", r -> r.path("/bizwebapi/**").uri("lb://ssjf49-store-api-web")).build();
        routes.route("ssjf49-store-mobile-web", r -> r.path("/bizapi/**").uri("lb://ssjf49-store-mobile-web")).build();
        return routes.build();
    }
}