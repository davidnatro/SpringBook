package part.i.chapter2.context.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        SomeComponent someComponent = context.getBean(SomeComponent.class);
        System.out.println(someComponent.getData());
    }
}
