package part.i.chapter2.context.beans;

import javax.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class SomeComponent {
    @Getter @Setter private String data;

    @PostConstruct
    public void init() {
        setData("some data");
    }
}
