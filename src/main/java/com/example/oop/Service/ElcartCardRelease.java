package com.example.oop.Service;

import com.example.oop.Entity.BankAccount;
import com.example.oop.util.Utils;

public class ElcartCardRelease implements CardFactory{
    @Override
    public BankAccount releaseCard() {
        
        return Utils.getMockAccountElcart();
    }
}
