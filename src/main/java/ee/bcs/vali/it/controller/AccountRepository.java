package ee.bcs.vali.it.controller;

import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AccountRepository {



    @Autowired
    private NamedParameterJdbcTemplate mydatabase;

    public String clientlogin(String userName) {
        String sql = "SELECT password FROM customer WHERE user_name = :user_name";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_name", userName);
        return mydatabase.queryForObject(sql, paramMap, String.class);
    }

    public void newaccount(String accountNr, BigDecimal balance, BigInteger customerId) {
        String sql = "INSERT INTO account (account_nr, balance, customer_id) VALUES (:account_nr, :balance, :customer_id)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        paramMap.put("balance", balance);
        paramMap.put("customer_id", customerId);
        mydatabase.update(sql, paramMap);
    }

    public void createclient(String firstName, String lastName, String userName, String password) {
        String sql = "INSERT INTO customer (first_name, last_name, user_name, password ) VALUES (:first_name, :last_name, :user_name, :password)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("first_name", firstName);
        paramMap.put("last_name", lastName);
        paramMap.put("user_name", userName);
        paramMap.put("password", password);
        mydatabase.update(sql, paramMap);
    }

    public BigDecimal askBalance(String accountNr) {
        String sql = "SELECT balance FROM account where account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        BigDecimal account_balance = mydatabase.queryForObject(sql, paramMap, BigDecimal.class);
        return account_balance;
    }

    public void deposit(String accountNr, BigDecimal balance) {
        String sql = "UPDATE account SET balance = balance + :balance where account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        paramMap.put("balance", balance);
        mydatabase.update(sql, paramMap);
    }

    public void withdraw(String accountNr, BigDecimal balance) {
        String sql = "UPDATE account SET balance = balance - :balance where account_nr = :account_nr and balance >= :balance";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        paramMap.put("balance", balance);
        mydatabase.update(sql, paramMap);
    }
    //transfer from
    public BigDecimal getBalance(String accountFrom) {
        String sql = "SELECT balance FROM account " + "WHERE account_nr = :account_nr";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountFrom);
        return mydatabase.queryForObject(sql, paramMap, BigDecimal.class);
    }
    //transfer to
    public void updateBalance(String account, BigDecimal balance) {
        String sql = "UPDATE account SET balance = :balance WHERE " + "account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("balance", balance);
        paramMap.put("account_nr", account);
        mydatabase.update(sql, paramMap);
    }
    public List showTransactionHistory(BigInteger accountId){
        String sql ="SELECT * FROM transaction_history WHERE account_id = :account_id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_id", accountId);
        List<BankClientsStatement> resultList = mydatabase.query(sql, paramMap, new AccountRowMapperNew());
        return resultList;
    }

    //J public void showTransactionHistory(String account, BigDecimal deposit, BigDecimal withdraw, BigDecimal balance){
    //    String sql = "INSERT INTO transactions(account_id, account, deposit, withdraw, balance) " +
    //            "VALUES (:account_id, :account, :deposit, :withdraw, :balance)";
    //    Map<String, Object> paramMap = new HashMap<>();
    //    paramMap.put("account", account);
    //    paramMap.put("deposit", deposit);
    //    paramMap.put("withdraw", withdraw);
    //    paramMap.put("balance", balance);
    //    dataBase.update(sql, paramMap);

    // Get account ID using account number
    public BigInteger getAccountId(String accountNr) {
        String sql = "SELECT id FROM account WHERE account_nr = :account_nr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_nr", accountNr);
        return mydatabase.queryForObject(sql, paramMap, BigInteger.class);
    }

    public void addTransactionAddFunds(BigInteger accountId, BigDecimal amount, BigDecimal balance) {
        String sql = "INSERT INTO transaction_history ( account_id, deposit, balance) VALUES ( :account_id, :deposit, :balance)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_id", accountId);
        paramMap.put("deposit", amount);
        paramMap.put("balance", balance);
        mydatabase.update(sql, paramMap);
    }

    public void addTransactionWithdrawFunds(BigInteger accountId, BigDecimal amount, BigDecimal balance) {
        String sql = "INSERT INTO transaction_history (account_id, withdraw, balance ) VALUES (:account_id, :withdraw, :balance )";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_id", accountId);
        paramMap.put("withdraw", amount);
        paramMap.put("balance", balance);
        mydatabase.update(sql, paramMap);
    }
    public void updateTransactionHistoryTransferFrom(BigInteger accountId, BigDecimal amount, BigDecimal balanceFrom) {
        String sql = "INSERT INTO transaction_history (account_id, withdraw, balance) VALUES (:account_id, :withdraw, :balance)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_id", accountId);
        paramMap.put("withdraw", amount);
        paramMap.put("balance", balanceFrom);
        mydatabase.update(sql, paramMap);
    }
    public void updateTransactionHistoryTransferTo(BigInteger accountId1,  BigDecimal amount, BigDecimal balanceTo) {
        String sql = "INSERT INTO transaction_history (account_id, deposit, balance) VALUES (:account_id, :deposit, :balance)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_id", accountId1);
        paramMap.put("deposit", amount);
        paramMap.put("balance", balanceTo);
        mydatabase.update(sql, paramMap);
    }
}

