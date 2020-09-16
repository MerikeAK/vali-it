package ee.bcs.vali.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController

public class BankControllerNew {


    @Autowired
    private AccountService accountService;

    @PostMapping("clientlogin")
    public void clientlogin (@RequestBody BankClientsSQL client) {
        accountService.clientlogin(client.getPassword());
    }

    @PostMapping("newaccount")
    public void newaccount(@RequestBody BankClientsSQL client) {
        accountService.newaccount(client.getAccountNr(), client.getBalance(), client.getCustomerId());
    }

    @PostMapping("createclient")
    public void createclient(@RequestBody BankClientsSQL client) {
        accountService.createclient(client.getFirstName(), client.getLastName(), client.getUserName(), client.getPassword());
    }

    @PostMapping("askbalance")
    public BigDecimal askBalance(@RequestBody BankClientsSQL client) {
        return accountService.askBalance(client.getAccountNr());
    }

    @PostMapping("deposit")
    public void deposit(@RequestBody BankClientsSQL client) {
        accountService.deposit(client.getAccountNr(), client.getBalance());
    }

    @PostMapping("withdraw")
    public void withdraw(@RequestBody BankClientsSQL client) {
        accountService.withdraw(client.getAccountNr(), client.getBalance());
    }

    @PostMapping("transfer2")
    public void transfer(@RequestBody BankClientsSQL client) {
        accountService.transfer(client.getAccountFrom(), client.getAccountTo(), client.getAmount());
    }

    /*@PutMapping("updateAllAccounts")
    public void updateAllAccounts(@RequestBody BankClientsSQL client) {
        accountService.updateAllAccounts(client.getAccountId(), client.getBalance());
    }*/
    //Shows statement of specified account
    @PostMapping("transaction_history")
    public List showTransactionHistory(@RequestBody BankClientsStatement client){
        return accountService.showTransactionHistory(client.getAccountId());
    }
}
//J @PostMapping("transaction_history")
//public List showStatementByAccount(@RequestBody BankClientsSQL client) {
//    return accountService.showTransactionHistory(client.getAccountId());