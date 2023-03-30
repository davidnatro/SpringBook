package part.ii.chapter12.databases.jdbc.connectionpools;

import java.math.BigDecimal;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

public class Purchase {
    @Getter @Setter private int id;
    @Getter @Setter private String product;
    @Getter @Setter private BigDecimal price;

    @Override
    public String toString() {
        return "Purchase{" + "id=" + id + ", product='" + product + '\'' + ", price=" + price + '}';
    }
}
