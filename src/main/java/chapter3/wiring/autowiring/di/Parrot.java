package chapter3.wiring.autowiring.di;

import lombok.Getter;
import lombok.Setter;

public class Parrot {
    @Getter @Setter private String name;

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }
}
