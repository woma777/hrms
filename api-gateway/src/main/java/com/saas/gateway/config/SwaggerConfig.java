package com.saas.gateway.config;

import static org.springdoc.core.utils.Constants.DEFAULT_API_DOCS_URL;

import jakarta.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class SwaggerConfig {

    private final SwaggerUiConfigProperties swaggerUiConfigProperties;
    private final RouteDefinitionLocator routeDefinitionLocator;

    @Bean
    public RouteLocator customSwaggerRoutes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routesBuilder = builder.routes();

        routeDefinitionLocator
                .getRouteDefinitions()
                .filter(routeDefinition -> routeDefinition.getId().endsWith("-service"))
                .toStream()
                .forEach(routeDefinition -> {
                    String name = routeDefinition.getId().replaceAll("-service", "");
                    String uri = routeDefinition.getUri().toString();

                    routesBuilder.route(name + "_docs",
                            r -> r.path(DEFAULT_API_DOCS_URL + "/" + name)
                            .filters(f -> f.setPath(DEFAULT_API_DOCS_URL))
                            .uri(uri));
                });

        return routesBuilder.build();
    }

    @PostConstruct
    public void init() {
        List<RouteDefinition> definitions =
                routeDefinitionLocator.getRouteDefinitions().collectList().block();

        if (definitions != null) {
            Set<AbstractSwaggerUiConfigProperties.SwaggerUrl> urls = new HashSet<>();
            definitions.stream()
                    .filter(routeDefinition -> routeDefinition.getId().endsWith("-service"))
                    .forEach(routeDefinition -> {
                        String name = routeDefinition.getId().replaceAll("-service", "");
                        String url = DEFAULT_API_DOCS_URL + "/" + name;
                        String displayName = capitalizeServiceName(routeDefinition.getId());
                        AbstractSwaggerUiConfigProperties.SwaggerUrl swaggerUrl =
                                new AbstractSwaggerUiConfigProperties.SwaggerUrl(name, url, displayName);
                        urls.add(swaggerUrl);
                    });
            swaggerUiConfigProperties.setUrls(urls);
        }
    }

    private String capitalizeServiceName(String serviceName) {
        String[] words = serviceName.split("-");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized
                        .append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return capitalized.toString().trim();
    }
}
