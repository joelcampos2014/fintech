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
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM T_ACCOUNT");
        ResultSet result = stm.executeQuery();
        List<Account> list = new ArrayList<>();

        while (result.next()) {
            Long id = result.getLong("ID");
            Date createdAt = result.getDate("CREATEDAT");
            Date updateAt = result.getDate("UPDATEAT");
            double balance = result.getDouble("BALANCE");
            String numberBank = result.getString("NUMBER_BANK");
            String agency = result.getString("AGENCY");
            String numberAccount = result.getString("NUMBER_ACCOUNT");
            list.add(parseAccount(result));
        }
        return list;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private Account parseAccount(ResultSet result) throws SQLException {
        Long id = result.getLong("ID");
        Date createdAt = result.getDate("CREATEDAT");
        Date updateAt = result.getDate("UPDATEAT");
        double balance = result.getDouble("BALANCE");
        String numberBank = result.getString("NUMBER_BANK");
        String agency = result.getString("AGENCY");
        String numberAccount = result.getString("NUMBER_ACCOUNT");
        return new Account(id, numberAccount, agency, numberBank, createdAt, balance, updateAt);
    }
}
