package com.example.oop.util;

import com.example.oop.Entity.BankAccount;
import com.example.oop.Enums.CardType;

import java.util.Random;

public class Utils {

   static final String visaCardPrefix = "416958";
   static final String elcartCardPrefix = "941760";
   static Random random = new Random();
  public static Integer counter = 0;
    public static BankAccount getMockAccountVisa() {

        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(Long.valueOf(counter++));
        bankAccount.setCardNum(visaCardPrefix +getRandomNumber(10));
        bankAccount.setCardType(CardType.VISA);
        return bankAccount;
    }
    public static BankAccount getMockAccountElcart() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(Long.valueOf(counter++));
        bankAccount.setCardNum(elcartCardPrefix +getRandomNumber(10));
        bankAccount.setCardType(CardType.ELCART);
        return bankAccount;
    }

    public static String getRandomNumber(int digCount) {
        StringBuilder sb = new StringBuilder(digCount);
        for (int i = 0; i < digCount; i++)
            sb.append (random.nextInt(10));
        return sb.toString();
    }
}
