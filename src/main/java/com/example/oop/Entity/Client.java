package com.example.oop.Entity;


public class Client {
    private Long id;

    private String fio;

    private boolean isPensioner;
    private BankAccount bankAccount;

    public Client(Long id, String fio, boolean isPensioner, BankAccount bankAccount) {
        this.id = id;
        this.fio = fio;
        this.isPensioner = isPensioner;
        this.bankAccount = bankAccount;
    }

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public boolean isPensioner() {
        return isPensioner;
    }

    public void setPensioner(boolean pensioner) {
        isPensioner = pensioner;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
