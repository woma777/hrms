package com.saas.gateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CircuitBreakerConfig {

    private final RouteDefinitionLocator routeDefinitionLocator;

    @Bean
    public RouteLocator dynamicRoutes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routesBuilder = builder.routes();

        routeDefinitionLocator
                .getRouteDefinitions()
                .filter(routeDefinition -> routeDefinition.getId().endsWith("-service"))
                .toStream()
                .forEach(routeDefinition -> {
                    String serviceName = routeDefinition.getId();
                    String name = serviceName.replace("-service", "Service");
                    String path = "/api/" + serviceName.replace("-service", "/**");
                    String uri = routeDefinition.getUri().toString();

                    routesBuilder.route(serviceName, r -> r.path(path)
                            .filters(f -> f.circuitBreaker(config -> config.setName(name + "CircuitBreaker")
                                    .setFallbackUri("forward:/fallback/" + serviceName)))
                            .uri(uri));
                });

        return routesBuilder.build();
    }
}
