package chapter2.context.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SomeComponent {
    @Getter @Setter private String data;

    @PostConstruct
    public void init() {
        setData("some data");
    }
}
