package br.com.fintech.view.BankStatement;

import br.com.fintech.dao.BankStatementDao;
import br.com.fintech.model.BankStatement;

import java.util.List;

public class ListBankStatementView {
    public static void main(String[] args) {
        try {
            BankStatementDao dao = new BankStatementDao();
            List<BankStatement> bankStatements = dao.getAll();
            for (BankStatement bankStatement : bankStatements) {
                System.out.println(bankStatement.getId() + " - " + bankStatement.getCreatedAt() + " - " + bankStatement.getUpdateAt()+ " - " + bankStatement.getName() + " - " + bankStatement.getAmount() + " - " + bankStatement.getMoveDate() + " - " + bankStatement.getDescription() + " - " + bankStatement.getAccountId());
            }
            dao.closeConnection();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
