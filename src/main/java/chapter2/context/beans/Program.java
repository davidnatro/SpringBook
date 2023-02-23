package chapter2.context.beans;

import chapter2.context.beans.ProjectConfiguration;
import chapter2.context.beans.SomeComponent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        SomeComponent someComponent = context.getBean(SomeComponent.class);
        System.out.println(someComponent.getData());
    }
}
