package br.com.fintech.dao;

import br.com.fintech.exception.ConnectionFailedException;
import br.com.fintech.exception.ObjectNotFoundException;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class AccountDao {

    private Connection connection;

    public AccountDao() throws SQLException, ConnectionFailedException {
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

    public void insert(Account account) throws SQLException {
        PreparedStatement stm = connection.prepareStatement("INSERT INTO ACCOUNT (ID, CREATED_AT,UPDATE_AT, BALANCE, " +
                "NUMBER_BANK, NUMBER_ACCOUNT, AGENCY) VALUES (SEQ_ACCOUNT.NEXTVAL, ?, ?, ?, ?, ?,?)");
        stm.setDate(1, account.getCreatedAt());
        stm.setDate(2, account.getUpdateAt());
        stm.setDouble(3, account.getBalance());
        stm.setString(4, account.getNumberBank());
        stm.setString(5, account.getNumberAccount());
        stm.setString(6, account.getAgency());
        stm.executeUpdate();
    }

    public Account getById(long id) throws  SQLException, ObjectNotFoundException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM ACCOUNT WHERE ID = ?");
        stm.setLong(1, id);
        ResultSet result = stm.executeQuery();

        if (!result.next())
            throw new ObjectNotFoundException("Conta");

        Long account_id = result.getLong("id");
        Date createdAt = result.getDate("created_at");
        Date updateAt = result.getDate("update_at");
        double balance = result.getDouble("balance");
        String numberBank = result.getString("number_bank");
        String agency = result.getString("number_account");
        String numberAccount = result.getString("agency");

        return new Account(account_id, numberAccount, agency, numberBank, createdAt, balance, updateAt);
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
