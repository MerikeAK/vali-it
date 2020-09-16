package ee.bcs.vali.it.controller;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BankClientsSQL {
    private int id;
    private String firstName;
    private String lastName;
    private String accountNr;
    private BigDecimal balance;
    private BigInteger customerId;
    private BigInteger accountId;
    private BigInteger accountIdFrom;
    private BigInteger accountIdTo;
    private String accountFrom;
    private String accountTo;
    private BigDecimal amount;
    private BigDecimal deposit;
    private BigDecimal withdraw;
    private BigDecimal transfer;
    private String userName;
    private String password;
    private BigDecimal balanceFrom;
    private BigDecimal balanceTo;
    private BigInteger accountId1;

    public BigInteger getAccountId1() {
        return accountId1;
    }

    public void setAccountId1(BigInteger accountId1) {
        this.accountId1 = accountId1;
    }

    public BigDecimal getBalanceFrom() {
        return balanceFrom;
    }

    public void setBalanceFrom(BigDecimal balanceFrom) {
        this.balanceFrom = balanceFrom;
    }

    public BigDecimal getBalanceTo() {
        return balanceTo;
    }

    public void setBalanceTo(BigDecimal balanceTo) {
        this.balanceTo = balanceTo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public BigDecimal getTransfer() {
        return transfer;
    }

    public void setTransfer(BigDecimal transfer) {
        this.transfer = transfer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(String accountNr) {
        this.accountNr = accountNr;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    public BigInteger getAccountId() {
        return accountId;
    }

    public void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
    }

    public BigInteger getAccountIdFrom() {
        return accountIdFrom;
    }

    public void setAccountIdFrom(BigInteger accountIdFrom) {
        this.accountIdFrom = accountIdFrom;
    }

    public BigInteger getAccountIdTo() {
        return accountIdTo;
    }

    public void setAccountIdTo(BigInteger accountIdTo) {
        this.accountIdTo = accountIdTo;
    }

    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }

    public String getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(String accountTo) {
        this.accountTo = accountTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
