package ee.bcs.vali.it.controller;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BankClientsStatement {

    private BigInteger accountId;
    private BigDecimal deposit;
    private BigDecimal withdraw;
    private BigDecimal balance;
    private BigInteger account;

    public BigInteger getAccount() {
        return account;
    }

    public void setAccount(BigInteger account) {
        this.account = account;
    }

    public BigInteger getAccountId() {
        return accountId;
    }

    public void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(BigDecimal withdraw) {
        this.withdraw = withdraw;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
