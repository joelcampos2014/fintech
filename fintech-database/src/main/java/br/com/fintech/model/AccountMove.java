package br.com.fintech.model;

import java.sql.Date;

public class AccountMove {
    private Long id;
    private Date createdAt;
    private Date updateAt;
    private String name;
    private double amount;
    private String type;
    private String description;
    private int accountId;

    public AccountMove(Long id, Date createdAt, Date updateAt, String name, double amount, String description, String type, int accountId) {
        this.id = id;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.accountId = accountId;
    }

    public AccountMove(Date createdAt, Date updateAt, String name, double amount, String type, String description, int accountId) {
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.name = name;
        this.amount = amount;
        this.type = type;
        this.description = description;
        this.accountId = accountId;
    }

    public AccountMove() {
    }

    public Long getId() {
        return id;
    }

    public AccountMove setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public AccountMove setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public AccountMove setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
        return this;
    }

    public String getName() {
        return name;
    }

    public AccountMove setName(String name) {
        this.name = name;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public AccountMove setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getType() {
        return type;
    }

    public AccountMove setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AccountMove setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getAccountId() {
        return accountId;
    }

    public AccountMove setAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }
}
