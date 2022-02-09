package operations;

import Model.*;
import operationexceptions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class CustomerOperationImpl implements CustomerOperations {
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    NumberFormat formatter;
    Locale nigeria;



    @Override
    public void addProductToCart(Map<Product, Integer> companyStocks, Map<Product, Integer> customerCart, Product product, int quantity) throws OutOfStockException {
        if (!companyStocks.containsKey(product)) throw new OutOfStockException("Store is currently out of " + product.getProductName());
        else if (companyStocks.get(product) >= quantity) {
            customerCart.computeIfPresent(product, (Product, Quantity) -> Quantity + quantity);
            customerCart.putIfAbsent(product, quantity);
        } else throw new OutOfStockException("Store has only " + companyStocks.get(product) + " " + product.getProductName());
    }

    @Override
    public void viewCustomerCart(Map<Product, Integer> customerCart) throws OutOfStockException{
        if (customerCart.size() > 0) {
            System.out.println(" ---- Cart Items ----");
            viewProducts(customerCart);
        } else throw new OutOfStockException("Cart is Empty!");
    }

    @Override
    public void buyProduct(Company company, Customer customer) throws OutOfStockException, OutOfFundException {
        nigeria = new Locale ("en", "NG");
        formatter = NumberFormat.getCurrencyInstance(nigeria);

        double totalProductPrice = 0.0;
        for (Map.Entry<Product, Integer> productInCart : customer.getCart().entrySet()){
            totalProductPrice += productInCart.getValue() * productInCart.getKey().getProductPrice();
        }
        if (totalProductPrice>customer.getWalletBalance()) throw new OutOfStockException("Out of fund! Total price: " + formatter.format(totalProductPrice) + " - Wallet Balance: " + formatter.format(customer.getWalletBalance()));
        else {
            customer.deductBalance(totalProductPrice);
            customer.getCart().entrySet().forEach(item -> {customer.getProductBoughtStack().put(item.getKey(), item.getValue());});
            generateReceipt(customer, company);
            customer.getCart().clear();
        }

        customer.deductBalance(totalProductPrice);
        company.receiveMoney(totalProductPrice);
    }

    @Override
    public void viewBoughtProducts(Map<Product, Integer> productBoughtSack) {
        nigeria = new Locale ("en", "NG");
        formatter = NumberFormat.getCurrencyInstance(nigeria);

        System.out.println(" ---- Bought products ----");
        viewProducts(productBoughtSack);
    }

    private void viewProducts(Map<Product, Integer> map) {
        int serialNum = 1;
        for (Map.Entry<Product, Integer> productSet : map.entrySet()) {
            Product product = productSet.getKey();
            int quantity = productSet.getValue();
            System.out.println( serialNum + " | Product name: " +product.getProductName() + " | Category: " + product.getProductCategory() + " | Quantity: " + quantity + " | Price: " + formatter.format(product.getProductPrice() *quantity) );
            serialNum++;
        }
    }

    @Override
    public void generateReceipt(Customer customer, Company company) {
        /* When a customer buys a product, a receipt should be generated called receipt.txt where
        the details of the purchase is contained. Details such as customer name, product bought, product
        category, price of the product and a success information. This should be written into the file in a
        key and value pair format.
         */

        System.out.println("Receipt Generated for " + customer.getFirstName() + ".");
        File file;

        try {
            file = new File("receipt-" + customer.getFirstName() +".txt");
            file.createNewFile();

            int totalPrice = 0;

            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

            fileWriter.write("--------- Aikay Exquisite Furniture ---------");
            fileWriter.write("\n Customer name: " + customer.getFirstName() + " " + customer.getLastName());

           for (var item : customer.getCart().entrySet()) {
                Product product = item.getKey();
                int quantity = item.getValue();
                try {
                    fileWriter.write("\n Product: " + product.getProductName());
                    fileWriter.write("\n Category: " + product.getProductCategory());
                    fileWriter.write(("\n Quantity : " + quantity));
                    fileWriter.write("\n Price per Unit: " + formatter.format(product.getProductPrice()));
                    fileWriter.write("\n Price per Product: " + formatter.format(product.getProductPrice() * quantity));
                    fileWriter.write(("\n ----------------------- \n -----------------------  "));
                } catch (IOException e) {System.out.println(e);}

                totalPrice += product.getProductPrice() * quantity;
            }

            fileWriter.write("\n Total : " + formatter.format(totalPrice) +
                                "\n Thanks for patronizing us!" + new String(Character.toChars( 128518)));

           fileWriter.close();

        } catch (IOException e) {System.out.println(e);}


    }

    @Override
    public void fundWallet(double wallet, double amount) throws IncorrectPasswordException {

    }
}
