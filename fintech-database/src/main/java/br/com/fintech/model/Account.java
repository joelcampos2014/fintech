package br.com.fintech.model;

import java.util.Date;

public class Account {
    private Long id;
    private String numberAccount;
    private String agency;
    private String numberBank;
    private double balance;
    private Date createdAt;
    private Date updateAt;

    public Account(String numberAccount, String agency, double balance, String numberBank, Date createdAt, Date updateAt) {
        this.numberAccount = numberAccount;
        this.agency = agency;
        this.balance = balance;
        this.numberBank = numberBank;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }

    public Account(Long id, String numberAccount, String agency, String numberBank, Date createdAt, double balance, Date updateAt) {
        this.id = id;
        this.numberAccount = numberAccount;
        this.agency = agency;
        this.numberBank = numberBank;
        this.createdAt = createdAt;
        this.balance = balance;
        this.updateAt = updateAt;
    }

    public Account() {
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public Account setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
        return this;
    }

    public String getAgency() {
        return agency;
    }

    public Account setAgency(String agency) {
        this.agency = agency;
        return this;
    }

    public String getNumberBank() {
        return numberBank;
    }

    public Account setNumberBank(String numberBank) {
        this.numberBank = numberBank;
        return this;
    }


    public double getBalance() {
        return balance;
    }

    public Account setBalance(double balance) {
        this.balance = balance;
        return this;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
