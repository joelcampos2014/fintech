package br.com.fintech.model;

import java.sql.Date;

public class Investment {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
    private String name;
    private String description;
    private String type;
    private int quantity;
    private Date investmentDate;
    private Date rescueDate;
    private double amount;
    private int accountId;

    public Investment(Long id, Date createdAt, Date updatedAt, String name, String description, String type, int quantity, Date investmentDate, Date rescueDate, double amount, int accountId) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.description = name;
        this.type = type;
        this.quantity = quantity;
        this.investmentDate = investmentDate;
        this.rescueDate = rescueDate;
        this.amount = amount;
        this.accountId = accountId;
    }

    public Investment(Date createdAt, Date updatedAt, String name, String description, String type, int quantity, Date investmentDate, Date rescueDate, double amount, int accountId) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.description = name;
        this.type = type;
        this.quantity = quantity;
        this.investmentDate = investmentDate;
        this.rescueDate = rescueDate;
        this.amount = amount;
        this.accountId = accountId;
    }

    public Investment() {
    }

    public Long getId() { return id; }

    public Investment setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreatedAt() { return createdAt; }

    public Investment setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Date getUpdatedAt() { return updatedAt; }

    public Investment setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getName() { return name; }

    public Investment setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() { return description; }

    public Investment setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getType() { return type; }

    public Investment setType(String type) {
        this.type = type;
        return this;
    }

    public int getQuantity() { return quantity; }

    public Investment setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Date getInvestmentDate() { return investmentDate; }

    public Investment setInvestmentDate(Date investmentDate) {
        this.investmentDate = investmentDate;
        return this;
    }

    public Date getRescueDate() { return rescueDate; }

    public Investment setRescueDate(Date rescueDate) {
        this.rescueDate = rescueDate;
        return this;
    }

    public double getAmount() { return amount; }

    public Investment setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public int getAccountId() { return accountId; }

    public Investment setAccountId(int accountId) {
        this.accountId = accountId;
        return this;
    }
}
