package br.com.fintech.dao;

import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountDao {

    private Connection connection;

    public AccountDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public List<Account> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM account");
        ResultSet result = stm.executeQuery();
        List<Account> list = new ArrayList<>();

        while (result.next()) {
            Long id = result.getLong("id");
            Date createdAt = result.getDate("created_at");
            Date updateAt = result.getDate("update_at");
            double balance = result.getDouble("balance");
            String numberBank = result.getString("number_bank");
            String agency = result.getString("number_account");
            String numberAccount = result.getString("agency");
            list.add(parseAccount(result));
        }
        return list;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Account parseAccount(ResultSet result) throws SQLException {
        Long id = result.getLong("id");
        Date createdAt = result.getDate("created_at");
        Date updateAt = result.getDate("update_at");
        double balance = result.getDouble("balance");
        String numberBank = result.getString("number_bank");
        String numberAccount = result.getString("number_account");
        String agency = result.getString("agency");
        return new Account(id, numberAccount, agency, numberBank, createdAt, balance, updateAt);
    }
}
