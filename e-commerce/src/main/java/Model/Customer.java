package Model;
import java.util.*;

import enums.Designation;

public class Customer extends Person {

    private double walletBalance;
    final private Map<Product, Integer> cart;
    final private Map<Product, Integer> productBoughtStack;

    public Customer(String firstName, String lastName, String address, double walletBalance){
        super(firstName, lastName, address, Designation.CUSTOMER);
        this.walletBalance = walletBalance;
        cart = new HashMap<>();
        productBoughtStack = new HashMap<>();
    }

    public double getWalletBalance() {return walletBalance;}

    public void deductBalance(double amount){walletBalance -= amount;}

    public Map<Product, Integer> getCart(){ return cart;}

    public Map<Product, Integer> getProductBoughtStack(){return productBoughtStack;}

}