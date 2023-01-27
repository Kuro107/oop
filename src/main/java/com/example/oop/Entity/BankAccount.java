package com.example.oop.Entity;

import com.example.oop.Enums.CardType;


public class BankAccount {

    private Long id;

    private String cardNum;

    private CardType cardType;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public BankAccount(Long id, String cardNum, CardType cardType) {
        this.id = id;
        this.cardNum = cardNum;
        this.cardType = cardType;
    }

    public BankAccount() {
    }
}
