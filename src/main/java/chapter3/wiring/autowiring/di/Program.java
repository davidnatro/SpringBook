package chapter3.wiring.autowiring.di;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        System.out.println(context.getBean(Person.class));
        System.out.println(context.getBean(Parrot.class));
    }
}
