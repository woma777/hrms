package com.saas.auth.service;

import com.saas.auth.dto.request.LoginRequest;
import com.saas.auth.dto.request.RefreshTokenRequest;
import com.saas.auth.exception.InvalidCredentialException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final WebClient webClient;

    @Value("${keycloak.server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    public AccessTokenResponse login(LoginRequest request) {
        try {
            Mono<AccessTokenResponse> responseMono = webClient
                    .post()
                    .uri(authServerUrl + "/realms/" + realm + "/protocol/openid-connect/token")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .bodyValue("grant_type=password&username=" + request.getUsername() + "&password="
                            + request.getPassword() + "&client_id="
                            + clientId + "&client_secret="
                            + clientSecret)
                    .retrieve()
                    .bodyToMono(AccessTokenResponse.class);
            return responseMono.block();
        } catch (WebClientResponseException.BadRequest e) {
            throw new InvalidCredentialException("Invalid username or password. Please check it again.");
        } catch (HttpServerErrorException.InternalServerError e) {
            throw new RuntimeException("Keycloak is unavailable. Please try again later.");
        }
    }

    public AccessTokenResponse refreshAccessToken(RefreshTokenRequest request) {
        try {
            Mono<AccessTokenResponse> responseMono = webClient
                    .post()
                    .uri(authServerUrl + "/realms/" + realm + "/protocol/openid-connect/token")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .bodyValue("grant_type=refresh_token&refresh_token=" + request.getRefreshToken() + "&client_id="
                            + clientId + "&client_secret="
                            + clientSecret)
                    .retrieve()
                    .bodyToMono(AccessTokenResponse.class);
            return responseMono.block();
        } catch (WebClientResponseException.BadRequest e) {
            throw new InvalidCredentialException("Invalid or expired token. Please check it again.");
        } catch (HttpServerErrorException.InternalServerError e) {
            throw new RuntimeException("Keycloak is unavailable. Please try again later.");
        }
    }

    public void logout(RefreshTokenRequest request) {

        webClient
                .post()
                .uri(authServerUrl + "/realms/" + realm + "/protocol/openid-connect/logout")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue("client_id=" + clientId + "&client_secret="
                        + clientSecret + "&refresh_token="
                        + request.getRefreshToken())
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
