package configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMapping (CorsRegistry registry) {

        registry.addMapping("/**").
                allowedOrigins("/*").
                allowedMethods("GET", "POST", "PUT", "DELETE").
                allowedHeaders("*");
    }
}
