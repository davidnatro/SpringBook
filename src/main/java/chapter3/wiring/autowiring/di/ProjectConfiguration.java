package chapter3.wiring.autowiring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {
    //    @Bean
    //    public Person person() {
    //        Person person = new Person();
    //        person.setName("Some name");
    //        person.setParrot(parrot());
    //
    //        return person;
    //    }

    @Bean
    public Person person(Parrot parrot) {
        Person person = new Person();
        person.setName("Some name");
        person.setParrot(parrot);

        return person;
    }

    @Bean
    public Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Some parrot");

        return parrot;
    }
}
