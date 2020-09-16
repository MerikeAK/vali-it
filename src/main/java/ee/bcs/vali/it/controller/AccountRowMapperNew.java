package ee.bcs.vali.it.controller;

import org.springframework.jdbc.core.RowMapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapperNew implements RowMapper<BankClientsStatement>{
    @Override
    public BankClientsStatement mapRow(ResultSet resultSet, int i) throws SQLException{
        BankClientsStatement clientData = new BankClientsStatement();
        clientData.setAccountId(BigInteger.valueOf(resultSet.getInt("account_id")));
        clientData.setDeposit(resultSet.getBigDecimal("deposit"));
        clientData.setWithdraw(resultSet.getBigDecimal("withdraw"));
        clientData.setBalance(resultSet.getBigDecimal("balance"));
        return clientData;

    }

}
