package maksym.kruhovykh.wekingsmonolith.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.http.HttpMethod.*;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200") // Разрешаем фронтенд
                        .allowedMethods(GET.name(), POST.name(), PUT.name(), DELETE.name(), OPTIONS.name())
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
