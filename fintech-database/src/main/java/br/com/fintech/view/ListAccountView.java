package br.com.fintech.view;

import br.com.fintech.model.Account;
import br.com.fintech.dao.AccountDao;
import java.sql.SQLException;
import java.util.List;

public class ListAccountView {
    public static void main(String[] args) {
        try {
            AccountDao dao = new AccountDao();
            List<Account> accounts = dao.getAll();
            for (Account account : accounts) {
                System.out.println(account.getId() + " - " + account.getBalance() + " - " + account.getNumberAccount()+ " - " + account.getNumberBank() + " - " + account.getCreatedAt() + " - " + account.getUpdateAt()+ " - " + account.getAgency());
            }
            dao.closeConnection();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
