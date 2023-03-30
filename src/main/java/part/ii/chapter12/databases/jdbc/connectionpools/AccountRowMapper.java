package part.ii.chapter12.databases.jdbc.connectionpools;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account result = new Account();

        result.setId(rs.getInt("id"));
        result.setName(rs.getString("name"));
        result.setAmount(rs.getBigDecimal("amount"));

        return result;
    }
}
