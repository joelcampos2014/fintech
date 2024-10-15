package br.com.fintech.view.AccountMove;

import br.com.fintech.dao.AccountMoveDao;

import br.com.fintech.model.AccountMove;

import java.sql.Date;

public class InsertAccountMoveView {
    public static void main(String [] agrs) {
        try {
            AccountMoveDao dao = new AccountMoveDao();
            AccountMove move = new AccountMove(new Date(2024,7, 1), new Date(2024,7, 1), "Conta de Água", 250.00, "payables", "Conta mensal", 10);
            dao.insert(move);
            dao.closeConnection();
            System.out.println("Recebível/Despesa cadastrado com Sucesso!");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
