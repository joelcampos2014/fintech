package br.com.fintech.dao;

import br.com.fintech.exception.ConnectionFailedException;
import br.com.fintech.exception.InvalidTypeException;
import br.com.fintech.exception.ObjectNotFoundException;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Account;
import br.com.fintech.model.Investment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvestmentDao {
    private Connection connection;

    public InvestmentDao() throws SQLException, ConnectionFailedException {
        connection = ConnectionFactory.getConnection();
    }

    public List<Investment> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM investement");
        ResultSet result = stm.executeQuery();
        List<Investment> list = new ArrayList<>();

        while (result.next()) {
            Long id = result.getLong("id");
            Date createdAt = result.getDate("created_at");
            Date updateAt = result.getDate("update_at");
            String name = result.getString("name");
            String description = result.getString("description");
            String type = result.getString("type");
            int quantity = result.getInt("quantity");
            Date investmentDate = result.getDate("investement_date");
            Date rescueDate = result.getDate("rescue_date");
            double amount = result.getDouble("amount");
            int accountId = result.getInt("account_id");
            list.add(parseInvestment(result));
        }
        return list;
    }

    public void Insert(Investment investment) throws SQLException, InvalidTypeException {
        try {
            PreparedStatement stm = connection.prepareStatement ("INSERT INTO Investement (ID, CREATED_AT, UPDATE_AT, NAME, " +
                    "DESCRIPTION, TYPE, QUANTITY, INVESTEMENT_DATE, RESCUE_DATE, AMOUNT, ACCOUNT_ID) VALUES (SEQ_Investement.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            AccountDao accountDao = new AccountDao();

            Account account = accountDao.getById(investment.getAccountId());

            stm.setDate(1, investment.getCreatedAt());
            stm.setDate (2, investment.getUpdatedAt());
            stm.setString(3, investment.getName());
            stm.setString(4, investment.getDescription());
            stm.setString(5, investment.getType());
            stm.setInt(6, investment.getQuantity());
            stm.setDate(7, investment.getInvestmentDate());
            stm.setDate(8, investment.getRescueDate());
            stm.setDouble(9, investment.getAmount());
            stm.setInt(10, investment.getAccountId());
            stm.executeUpdate();
        } catch (ObjectNotFoundException | ConnectionFailedException e) {
            System.err.println(e.getMessage());
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Investment parseInvestment(ResultSet result) throws SQLException {
        Long id = result.getLong("id");
        Date createdAt = result.getDate("created_at");
        Date updateAt = result.getDate("update_at");
        String name = result.getString("name");
        String description = result.getString("description");
        String type = result.getString("type");
        int quantity = result.getInt("quantity");
        Date investmentDate = result.getDate("investement_date");
        Date rescueDate = result.getDate("rescue_date");
        double amount = result.getDouble("amount");
        int accountId = result.getInt("account_id");
        return new Investment(id, createdAt, updateAt, name, description, type, quantity, investmentDate, rescueDate, amount, accountId);
    }
}


