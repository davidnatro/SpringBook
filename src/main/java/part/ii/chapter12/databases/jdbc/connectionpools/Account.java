package part.ii.chapter12.databases.jdbc.connectionpools;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

public class Account {
    @Id @Getter @Setter private long id;
    @Getter @Setter private String name;
    @Getter @Setter private BigDecimal amount;
}
