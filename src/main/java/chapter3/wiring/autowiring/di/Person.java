package chapter3.wiring.autowiring.di;

import lombok.Getter;
import lombok.Setter;

public class Person {
    @Getter @Setter private String name;
    @Getter @Setter private Parrot parrot;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", parrot=" + parrot +
                '}';
    }
}
