package br.com.fintech.view.BankStatement;

import br.com.fintech.dao.BankStatementDao;
import br.com.fintech.model.BankStatement;

import java.sql.Date;

public class InsertBankStatementView {
    public static void main(String [] agrs) {
        try {
            BankStatementDao dao = new BankStatementDao();
            BankStatement bankStatement = new BankStatement(new Date(2024,7, 1), new Date(2024,7, 1), "Transferência", -250.00, new Date(2024,7, 1), "PIX", 10);
            dao.insert(bankStatement);
            dao.closeConnection();
            System.out.println("Movimentação de extrato cadastrada com Sucesso!");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
