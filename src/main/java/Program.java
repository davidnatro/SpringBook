import chapter2.context.beans.Parrot;
import chapter2.context.beans.ProjectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Program {
    public static void main(String[] args){
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        Parrot parrot = new Parrot();
    }
}
