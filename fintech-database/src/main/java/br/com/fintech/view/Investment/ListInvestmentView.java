package br.com.fintech.view.Investment;

import br.com.fintech.dao.InvestmentDao;
import br.com.fintech.model.Investment;


import java.util.List;

public class ListInvestmentView {
    public static void main(String[] args) {
        try {
            InvestmentDao dao = new InvestmentDao();
            List<Investment> investments = dao.getAll();
            for (Investment investment : investments) {
                System.out.println(investment.getId() + " - " + investment.getCreatedAt() + " - " + investment.getUpdatedAt() + " - " + investment.getName()
                        + " - " + investment.getDescription() + " - " + investment.getType() + " - " + investment.getQuantity() + " - " + investment.getInvestmentDate()
                        + " - " + investment.getRescueDate() + " - " + investment.getAmount() + " - " + investment.getAccountId());
            }
            dao.closeConnection();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
