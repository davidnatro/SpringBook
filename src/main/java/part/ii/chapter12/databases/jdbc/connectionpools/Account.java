package part.ii.chapter12.databases.jdbc.connectionpools;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

public class Account {
    @Getter @Setter private long id;
    @Getter @Setter private String name;
    @Getter @Setter private BigDecimal amount;
}
