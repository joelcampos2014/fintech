package br.com.fintech.view;

import br.com.fintech.dao.AccountDao;
import br.com.fintech.model.Account;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class InsertAccountView {
    public static void main(String [] agrs) {
        try {
            AccountDao dao = new AccountDao();
            Account account = new Account("75223612", "176", 9000.00, "333", new Date(2024,6,9),
                    new Date(2024,7, 1));
            dao.insert(account);
            dao.closeConnection();
            System.out.println("Conta Cadastrada Com Sucesso!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
