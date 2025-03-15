package br.com.dev.MechGear.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/login")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("POST")
                .allowCredentials(true);

        registry.addMapping("/login")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("POST","GET","PUT","DELETE")
                .allowCredentials(true);
    }
}
