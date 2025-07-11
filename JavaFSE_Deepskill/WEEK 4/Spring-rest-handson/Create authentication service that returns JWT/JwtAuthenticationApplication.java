package com.example.jwtauthenticationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication(scanBasePackages = {
    "com.example.jwtauthenticationservice",
    "com.example.jwt"
})
public class JwtAuthenticationApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "8787");
        SpringApplication.run(JwtAuthenticationApplication.class, args);
    }

    @Bean
    public CommandLineRunner portValidator(Environment env) {
        return args -> {
            String port = env.getProperty("server.port");
            System.out.println("\n Server will attempt to start on port: " + port);
        };
    }

    @EventListener
    public void onStartup(ApplicationReadyEvent event) {
        Environment env = event.getApplicationContext().getEnvironment();
        String port = env.getProperty("local.server.port");
        System.out.println("\n JWT Authentication Service is running!");
        System.out.println(" http://localhost:" + port + "/authenticate");
        System.out.println(" Default credentials: user/pwd\n");
    }
}
