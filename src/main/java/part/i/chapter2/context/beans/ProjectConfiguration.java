package part.i.chapter2.context.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "chapter2.context.beans") // == @ComponentScan
public class ProjectConfiguration {
    @Bean
    public Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Koko");

        return parrot;
    }
}
