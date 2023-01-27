package com.example.oop.Service;

import com.example.oop.Entity.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class Store {
    static List<Products> products = new ArrayList<>();
   static Scanner scanner = new Scanner(System.in);

    public static void store(int clientID) {
        long id = 1;
        long price = 900;
        byte model = 7;
        for (int i = 0; i < 6; i++) {
            Products products1 = new Products(id, "Iphone", price, "cellphone", "some--description", model);
            products.add(products1);
            id++;
            price += 50;
            model++;
        }
        System.out.print("choose product and write their id " + products.toString());
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number-1 <= products.size()){
            products.get(number-1);
                System.out.println("Select a Payment Method"+ "\n 1 to choose visa\n2 to choose elcart");
                if (scanner.hasNextInt()) {
                    int cardType = scanner.nextInt();
                    if (cardType == 1 && ClientService.clients.get(clientID).isPensioner()){
                        PayProcessing.MPCvisaPayProcessing(ClientService.clients.get(clientID).getBankAccount().getCardNum(),(products.get(number-1).getPrice()));}

                    else if((cardType == 1 && !ClientService.clients.get(clientID).isPensioner())) {
                        PayProcessing.way4visaPayProcessing(ClientService.clients.get(clientID).getBankAccount().getCardNum(),(products.get(number-1).getPrice()));}

                    else if(cardType == 2&& ClientService.clients.get(clientID).isPensioner()){
                        PayProcessing.MPCelcartPayProcessing(ClientService.clients.get(clientID).getBankAccount().getCardNum(),(products.get(number-1).getPrice()));}

                    else if((cardType == 2 && !ClientService.clients.get(clientID).isPensioner())) {
                        PayProcessing.way4elcartPayProcessing(ClientService.clients.get(clientID).getBankAccount().getCardNum(),(products.get(number-1).getPrice()));}
                } else {
                    System.out.println("Sorry, restart the program and try again");
                }


            }
           else System.out.println("sorry choose correct id");
        } else {
            System.out.println("Sorry, restart the program and try again");

        }
    }
}

