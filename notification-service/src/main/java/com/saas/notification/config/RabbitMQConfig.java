package com.saas.notification.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {

    private final ApplicationProperties properties;

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(properties.leaveEventsExchange());
    }

    @Bean
    public Queue requestedLeavesQueue() {
        return QueueBuilder.durable(properties.requestedLeavesQueue()).build();
    }

    @Bean
    public Binding requestedLeavesBinding() {
        return BindingBuilder.bind(requestedLeavesQueue()).to(exchange()).with(properties.requestedLeavesRoutingKey());
    }

    @Bean
    public Queue approvedLeavesQueue() {
        return QueueBuilder.durable(properties.approvedLeavesQueue()).build();
    }

    @Bean
    public Binding approvedLeaveBinding() {
        return BindingBuilder.bind(approvedLeavesQueue()).to(exchange()).with(properties.approvedLeavesRoutingKey());
    }

    @Bean
    public Queue rejectedLeavesQueue() {
        return QueueBuilder.durable(properties.rejectedLeavesQueue()).build();
    }

    @Bean
    public Binding rejectedLeaveBinding() {
        return BindingBuilder.bind(rejectedLeavesQueue()).to(exchange()).with(properties.rejectedLeavesRoutingKey());
    }

    @Bean
    public Queue cancelledLeavesQueue() {
        return QueueBuilder.durable(properties.cancelledLeavesQueue()).build();
    }

    @Bean
    public Binding cancelledLeavesBinding() {
        return BindingBuilder.bind(cancelledLeavesQueue()).to(exchange()).with(properties.cancelledLeavesRoutingKey());
    }

    @Bean
    public Jackson2JsonMessageConverter jacksonConverter(ObjectMapper mapper) {
        return new Jackson2JsonMessageConverter(mapper);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory factory, ObjectMapper mapper) {
        final var rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(jacksonConverter(mapper));
        return rabbitTemplate;
    }

    @Bean
    public JavaMailSender mailSender() {
        return new JavaMailSenderImpl();
    }
}
