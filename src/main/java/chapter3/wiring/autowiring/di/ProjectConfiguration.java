package chapter3.wiring.autowiring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("chapter3")
public class ProjectConfiguration {
    // Wiring using method calling.
    //    @Bean
    //    public Person person() {
    //        Person person = new Person();
    //        person.setName("Some name");
    //        person.setParrot(parrot());
    //
    //        return person;
    //    }

    // Wiring using method argument.
    //    @Bean
    //    public Person person(Parrot parrot) {
    //        Person person = new Person();
    //        person.setName("Some name");
    //        person.setParrot(parrot);
    //
    //        return person;
    //    }

    //    @Bean
    //    public Parrot parrot() {
    //        Parrot parrot = new Parrot();
    //        parrot.setName("Some parrot");
    //
    //        return parrot;
    //    }
}
