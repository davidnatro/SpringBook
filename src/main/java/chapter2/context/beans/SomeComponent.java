package chapter2.context.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class SomeComponent {
    @Getter @Setter private String data;
}
