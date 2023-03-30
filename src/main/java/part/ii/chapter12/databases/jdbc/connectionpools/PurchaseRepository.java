package part.ii.chapter12.databases.jdbc.connectionpools;

import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbc;

    public PurchaseRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    public void addPurchase(Purchase purchase) {
        final String sql = "INSERT INTO purchase VALUES (DEFAULT, ?, ?)";
        jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAllPurchases() {
        final String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper = (resultSet, rowNumber) -> {
            Purchase purchase = new Purchase();
            purchase.setId(resultSet.getInt("id"));
            purchase.setProduct(resultSet.getString("product"));
            purchase.setPrice(resultSet.getBigDecimal("price"));
            return purchase;
        };

        return jdbc.query(sql, purchaseRowMapper);
    }
}
