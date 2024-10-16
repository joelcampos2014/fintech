package br.com.fintech.view.Investment;

import br.com.fintech.dao.InvestmentDao;

import br.com.fintech.model.Investment;

import java.sql.Date;

public class InsertInvestmentView {
    public static void main(String [] agrs) {
        try {
            InvestmentDao dao = new InvestmentDao();
            Investment investment = new Investment(new Date(2024,8, 10), new Date(2024,8, 10), "Investimento em Fundo Imobiliário",
                    "Rendimento mensal", "Fundo Imobiliário", 20, new Date(2024,8, 10), new Date(2024,8, 10),
                    750.00, 10);
            dao.Insert(investment);
            dao.closeConnection();
            System.out.println("Cadastro de Investimento efetuado!");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
