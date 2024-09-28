package dev.farhan.movieist;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MovieistApplication {

    public static void main(String[] args) {
        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.configure().load();

        // Print environment variables for debugging
        System.out.println("MONGO_USER: " + dotenv.get("MONGO_USER"));
        System.out.println("MONGO_PASSWORD: " + dotenv.get("MONGO_PASSWORD"));
        System.out.println("MONGO_CLUSTER: " + dotenv.get("MONGO_CLUSTER"));
        System.out.println("MONGO_DATABASE: " + dotenv.get("MONGO_DATABASE"));

        // Start the Spring Boot application
        SpringApplication.run(MovieistApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(false)
                        .maxAge(3600);
            }
        };
    }
}
