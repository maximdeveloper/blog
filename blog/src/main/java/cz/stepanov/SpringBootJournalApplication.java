package cz.stepanov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class SpringBootJournalApplication {

//   @Bean
//   public WebMvcConfigurer corsConfigurer() {
//      return new WebMvcConfigurerAdapter() {
//         @Override
//         public void addCorsMappings(CorsRegistry registry) {
//            registry.addMapping("/api/journals").allowedOrigins("http://localhost:4200");
//         }
//      };
//   }
   
   public static void main(String[] args) {
      SpringApplication.run(SpringBootJournalApplication.class, args);
   }
}
