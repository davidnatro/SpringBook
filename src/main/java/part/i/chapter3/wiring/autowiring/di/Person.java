package part.i.chapter3.wiring.autowiring.di;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class Person {
    @Getter @Setter private String name = "default name";

    @Getter private final Parrot parrot;

    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", parrot=" + parrot +
                '}';
    }
}
