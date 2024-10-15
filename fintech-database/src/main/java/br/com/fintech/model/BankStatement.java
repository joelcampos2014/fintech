package br.com.fintech.model;

import java.sql.Date;

public class BankStatement {
    private Long id;
    private Date createdAt;
    private Date updateAt;
    private String name;
    private double amount;
    private Date moveDate;
    private String description;
    private int accountId;

    public BankStatement(Long id, Date createdAt, Date updateAt, String name, double amount, Date moveDate, String description, int accountId) {
        this.id = id;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.name = name;
        this.amount = amount;
        this.moveDate = moveDate;
        this.description = description;
        this.accountId = accountId;
    }

    public BankStatement(Date createdAt, Date updateAt, String name, double amount, Date moveDate, String description, int accountId) {
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.name = name;
        this.amount = amount;
        this.moveDate = moveDate;
        this.description = description;
        this.accountId = accountId;
    }

    public BankStatement() {
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public BankStatement setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public BankStatement setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
        return this;
    }

    public String getName() {
        return name;
    }

    public BankStatement setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public BankStatement setId(Long id) {
        this.id = id;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public BankStatement setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public Date getMoveDate() {
        return moveDate;
    }

    public BankStatement setMoveDate(Date moveDate) {
        this.moveDate = moveDate;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BankStatement setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getAccountId() {
        return accountId;
    }

    public BankStatement setAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }
}
