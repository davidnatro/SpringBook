package part.ii.chapter12.databases.jdbc.connectionpools;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

public class TrasnferRequest {
    @Getter @Setter private long senderId;
    @Getter @Setter private long receiverId;
    @Getter @Setter private BigDecimal amount;
}
