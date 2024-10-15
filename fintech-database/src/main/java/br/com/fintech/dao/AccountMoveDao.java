package br.com.fintech.dao;

import br.com.fintech.exception.ConnectionFailedException;
import br.com.fintech.exception.InvalidTypeException;
import br.com.fintech.exception.ObjectNotFoundException;
import br.com.fintech.factory.ConnectionFactory;
import br.com.fintech.model.Account;
import br.com.fintech.model.AccountMove;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountMoveDao {
    private Connection connection;

    public AccountMoveDao() throws SQLException, ConnectionFailedException {
        connection = ConnectionFactory.getConnection();
    }

    public List<AccountMove> getAll() throws SQLException {
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM account_move");
        ResultSet result = stm.executeQuery();
        List<AccountMove> list = new ArrayList<>();

        while (result.next()) {
            Long id = result.getLong("id");
            Date createdAt = result.getDate("created_at");
            Date updateAt = result.getDate("update_at");
            String name = result.getString("name");
            double amount = result.getDouble("amount");
            String type = result.getString("type");
            String description = result.getString("description");
            Long accountId = result.getLong("account_id");
            list.add(parseAccountMove(result));
        }
        return list;
    }

    public void insert(AccountMove move) throws SQLException, InvalidTypeException {
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO ACCOUNT_MOVE (ID, CREATED_AT,UPDATE_AT, NAME, " +
                    "AMOUNT, TYPE, DESCRIPTION, ACCOUNT_ID) VALUES (SEQ_ACCOUNT_MOVE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");

            AccountDao accountDao = new AccountDao();
            List<String> types = accountDao.getTypes();

            if (!types.contains(move.getType()))
                throw new InvalidTypeException(move.getType());

            Account account = accountDao.getById(move.getAccountId());

            stm.setDate(1, move.getCreatedAt());
            stm.setDate(2, move.getUpdateAt());
            stm.setString(3, move.getName());
            stm.setDouble(4, move.getAmount());
            stm.setString(5, move.getType());
            stm.setString(6, move.getDescription());
            stm.setLong(7, account.getId());
            stm.executeUpdate();

        } catch (ObjectNotFoundException | ConnectionFailedException e) {
            System.err.println(e.getMessage());
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    private AccountMove parseAccountMove(ResultSet result) throws SQLException {
        Long id = result.getLong("id");
        Date createdAt = result.getDate("created_at");
        Date updateAt = result.getDate("update_at");
        String name = result.getString("name");
        double amount = result.getDouble("amount");
        String type = result.getString("type");
        String description = result.getString("description");
        int accountId = result.getInt("account_id");
        return new AccountMove(id, createdAt, updateAt, name, amount, description, type, accountId);
    }
}
