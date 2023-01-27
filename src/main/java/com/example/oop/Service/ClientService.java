package com.example.oop.Service;


import com.example.oop.Entity.BankAccount;
import com.example.oop.Entity.Client;
import com.example.oop.Enums.CardType;
import com.example.oop.util.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class ClientService {
    static List<Client> clients = new ArrayList<>();
    static List<BankAccount> bankAccounts = new ArrayList<>();
    public static Boolean login(int id){
        int counter = 0;
        for (int i = 0; i < clients.size(); i++) {
           if (clients.get(i).getId() == id){
               counter++;
           }
        }
        if (counter==1){
            return true;
        }
         else return false;
    }

    public static void clientMenu() {
        long id = 1;
        for (int i = 0; i < 10; i++) {
            BankAccount bankAccount = new BankAccount();
            if (i % 2 == 0){
                bankAccount.setId(Utils.getMockAccountVisa().getId());
                bankAccount.setCardNum(Utils.getMockAccountVisa().getCardNum());
                bankAccount.setCardType(Utils.getMockAccountVisa().getCardType());
            }
            else {
                bankAccount.setId(Utils.getMockAccountElcart().getId());
            bankAccount.setCardNum(Utils.getMockAccountElcart().getCardNum());
            bankAccount.setCardType(Utils.getMockAccountElcart().getCardType());
            }
            bankAccounts.add(bankAccount);

            Client client = new Client(id, "asd", false,bankAccount);
            clients.add(client);
            id++;
        }
        boolean exit = true;
        Scanner scanner = new Scanner(System.in);
        while (exit) {
            System.out.println("Login\nWrite your id");
            if (scanner.hasNextInt()){
            int clientID = scanner.nextInt();
            if (login(clientID)) {
                Store.store(clientID);
                exit=false;
            } else {
                Client client = new Client();
                //set client id
                client.setId(clients.get(clients.size() - 1).getId() + 1);
                //register
                System.out.println("registration\n" +
                        "write your full name:");
                //client name
                scanner.nextLine();
                if (scanner.hasNextLine()) {
                    client.setFio(scanner.nextLine());
                    System.out.println("choose your card type " +
                            "\nWrite 1 to choose Visa" +
                            "\n Write 2 to choose Elcart");
                    System.out.print("");
                    //choose card type
                    BankAccount bankAccount = new BankAccount();
                    bankAccount.setId(Long.valueOf(Utils.counter++));
                    if (scanner.hasNextInt()) {
                        int cartType = scanner.nextInt();
                        if (cartType == 1) {
                            bankAccount.setCardType(CardType.VISA);
                        } else if (cartType == 2) {
                            bankAccount.setCardType(CardType.ELCART);
                        } else {
                            System.out.println("your choose is incorrect");
                            exit = false;
                        }
                        //pensioner
                        System.out.println(
                                "\nWrite 1 if you are pensioner" +
                                        "\n Write 2 if you not pensioner");
                        int pensioner = scanner.nextInt();
                        if (pensioner == 1) {
                            client.setPensioner(true);
                        } else if (pensioner == 2) {
                            client.setPensioner(false);
                            System.out.println("write your card num");
                            bankAccount.setCardNum(scanner.next());
                            client.setBankAccount(bankAccount);
                            //add new client
                            bankAccounts.add(bankAccount);
                            clients.add(client);
                            System.out.println("Your id  to login  is = " + clients.size());
                        }
                        else System.out.println("your choose is incorrect");

                    }
                    else {
                        System.out.println("Sorry, restart the program and try again");
                    exit = false;}

                }
                else {
                    System.out.println("Sorry, restart the program and try again");
                    exit = false;}
            }

            }
            else {
                System.out.println("Sorry, restart the program and try again");
                exit = false;}

        }
    }
}
