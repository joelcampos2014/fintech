package br.com.fintech.view.AccountMove;

import br.com.fintech.dao.AccountMoveDao;
import br.com.fintech.model.AccountMove;

import java.util.List;

public class ListAcccountMoveView {
    public static void main(String[] args) {
        try {
            AccountMoveDao dao = new AccountMoveDao();
            List<AccountMove> accountMoves = dao.getAll();
            for (AccountMove move : accountMoves) {
                System.out.println(move.getId() + " - " + move.getCreatedAt() + " - " + move.getUpdateAt()+ " - " + move.getName() + " - " + move.getAmount() + " - " + move.getType() + " - " + move.getDescription() + " - " + move.getAccountId());
            }
            dao.closeConnection();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
