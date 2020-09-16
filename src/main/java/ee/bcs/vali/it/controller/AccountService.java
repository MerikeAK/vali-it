package ee.bcs.vali.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class AccountService {


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String clientlogin(String password) {
        return passwordEncoder.encode(password);
    }

    public void newaccount(String accountNr, BigDecimal balance, BigInteger customerId) {
        accountRepository.newaccount(accountNr, balance, customerId);
    }

    public void createclient(String firstName, String lastName, String userName, String password) {
        accountRepository.createclient(firstName, lastName, userName, passwordEncoder.encode(password));//lisan parooli kodeeria
    }

    public BigDecimal askBalance(String accountNr) {
        return accountRepository.askBalance(accountNr);
    }

    public void deposit(String accountNr, BigDecimal amount) {
        accountRepository.deposit(accountNr, amount);
        BigInteger accountId = accountRepository.getAccountId(accountNr);
        BigDecimal balance = accountRepository.getBalance(accountNr);
        accountRepository.addTransactionAddFunds(accountId, amount, balance);

    }
    public void withdraw(String accountNr, BigDecimal amount) {
        accountRepository.withdraw(accountNr, amount);
        BigInteger accountId = accountRepository.getAccountId(accountNr);
        BigDecimal balance = accountRepository.getBalance(accountNr);
        accountRepository.addTransactionWithdrawFunds(accountId, amount, balance);
    }

    public void transfer(String accountFrom, String accountTo, BigDecimal amount) {
        BigDecimal fromAccountBalance = accountRepository.getBalance(accountFrom);
        if (fromAccountBalance.compareTo(amount) >= 0) {
            BigDecimal toAccountBalance = accountRepository.getBalance(accountTo);
            fromAccountBalance = fromAccountBalance.subtract(amount);
            toAccountBalance = toAccountBalance.add(amount);
            accountRepository.updateBalance(accountFrom, fromAccountBalance);
            accountRepository.updateBalance(accountTo, toAccountBalance);
            BigInteger accountId = accountRepository.getAccountId(accountFrom);
            BigInteger accountId1 = accountRepository.getAccountId(accountTo);
            accountRepository.updateTransactionHistoryTransferFrom(accountId, amount, fromAccountBalance);
            accountRepository.updateTransactionHistoryTransferTo(accountId1, amount, toAccountBalance);

        }
    }
    //Shows all transactions of specified account from table 'transactions_history'
    public List showTransactionHistory (BigInteger accountId){
        return accountRepository.showTransactionHistory (accountId);
    }
}
//J //Shows all transactions of specified account from table 'transactions'
//     public List showTransactionHistory(BigInteger customerId){
//     return accountRepository.showStatementByAccount(customerId);