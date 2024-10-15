package br.com.fintech.dao;

import br.com.fintech.exception.ConnectionFailedException;
import br.com.fintech.exception.InvalidTypeException;
import br.com.fintech.exception.ObjectNotFoundException;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Account;
import br.com.fintech.model.BankStatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BankStatementDao {
    private Connection connection;

    public BankStatementDao() throws SQLException, ConnectionFailedException {
        connection = ConnectionFactory.getConnection();
    }

    public List<BankStatement> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM bank_statement");
        ResultSet result = stm.executeQuery();
        List<BankStatement> list = new ArrayList<>();

        while (result.next()) {
            Long id = result.getLong("id");
            Date createdAt = result.getDate("created_at");
            Date updateAt = result.getDate("update_at");
            String name = result.getString("name");
            double amount = result.getDouble("amount");
            Date date = result.getDate("move_date");
            String description = result.getString("description");
            Long accountId = result.getLong("account_id");
            list.add(parseBankStatement(result));
        }
        return list;
    }

    public void insert(BankStatement bankStatement) throws SQLException {
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO BANK_STATEMENT (ID, CREATED_AT,UPDATE_AT, NAME, " +
                    "AMOUNT, MOVE_DATE, DESCRIPTION, ACCOUNT_ID) VALUES (SEQ_ACCOUNT_MOVE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");

            AccountDao accountDao = new AccountDao();

            Account account = accountDao.getById(bankStatement.getAccountId());

            stm.setDate(1, bankStatement.getCreatedAt());
            stm.setDate(2, bankStatement.getUpdateAt());
            stm.setString(3, bankStatement.getName());
            stm.setDouble(4, bankStatement.getAmount());
            stm.setDate(5, bankStatement.getMoveDate());
            stm.setString(6, bankStatement.getDescription());
            stm.setLong(7, account.getId());
            stm.executeUpdate();

        } catch (ObjectNotFoundException | ConnectionFailedException e) {
            System.err.println(e.getMessage());
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private BankStatement parseBankStatement(ResultSet result) throws SQLException {
        Long id = result.getLong("id");
        Date createdAt = result.getDate("created_at");
        Date updateAt = result.getDate("update_at");
        String name = result.getString("name");
        double amount = result.getDouble("amount");
        Date moveDate = result.getDate("move_date");
        String description = result.getString("description");
        int accountId = result.getInt("account_id");
        return new BankStatement(id, createdAt, updateAt, name, amount, moveDate, description, accountId);
    }
}
