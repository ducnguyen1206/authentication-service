package com.sushi.tuyenbeoo.authentication.service.infrastructure.config;


import com.sushi.tuyenbeoo.authentication.service.application.controller.UserController;
import com.sushi.tuyenbeoo.authentication.service.domain.data.UserData;
import com.sushi.tuyenbeoo.authentication.service.domain.service.user.UserService;
import com.sushi.tuyenbeoo.authentication.service.domain.service.impl.UserServiceImpl;
import com.sushi.tuyenbeoo.authentication.service.infrastructure.data.UserDataImpl;
import com.sushi.tuyenbeoo.authentication.service.infrastructure.data.UserDetailsServiceImpl;
import com.sushi.tuyenbeoo.authentication.service.infrastructure.repository.UserRepository;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Value("#{${dish.code.config:null}}")
    Map<Integer, Map<String, Integer>> simpleMap =null;

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Bean
    public UserData userData() {
        return new UserDataImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userData());
    }

    @Bean
    public UserDetailsService userDetailsService(final UserRepository userRepository) {
        final Map<Integer, Map<String, Integer>> dishCodeConfig =this.simpleMap;
        return new UserDetailsServiceImpl(userRepository);
    }

    @Bean
    public UserController userController() {
        return new UserController(simpleMap, userService());
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
