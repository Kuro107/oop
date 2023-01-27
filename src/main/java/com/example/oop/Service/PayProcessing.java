package com.example.oop.Service;



public class PayProcessing {

    public static void MPCvisaPayProcessing(String cardNum, Long price) {
        System.out.println("вы совершили оплату " + price + "$ картой visa" + cardNum);
    }
        public static void way4visaPayProcessing (String cardNum, Long price){
            System.out.println("вы совершили оплату " + price + "$ картой visa" + cardNum);

        }
        public static void MPCelcartPayProcessing (String cardNum, Long price) {
            System.out.println("вы совершили оплату " + price + "$ картой elcart" + cardNum);
        }
            public static void way4elcartPayProcessing (String cardNum, Long price){
                System.out.println("вы совершили оплату " + price + "$ картой elcart" + cardNum);
            }
        }

