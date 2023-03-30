package part.ii.chapter12.databases.jdbc.connectionpools;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {
    private final JdbcTemplate jdbc;

    public AccountRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    public List<Account> findAllAccounts() {
        final String sql = "SELECT * FROM account";

        return jdbc.query(sql, new AccountRowMapper());
    }

    public Account findAccountById(long id) {
        final String sql = "SELECT * FROM account WHERE id = ?";

        return jdbc.queryForObject(sql, new AccountRowMapper(), id);
    }

    public void changeAmount(long id, BigDecimal amount) {
        final String sql = "UPDATE account SET amount = ? WHERE id = ?";

        jdbc.update(sql, amount, id);
    }
}
