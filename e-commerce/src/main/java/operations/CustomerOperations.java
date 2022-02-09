package operations;


import Model.Company;
import Model.Customer;
import Model.Product;
import operationexceptions.IncorrectPasswordException;
import operationexceptions.OutOfFundException;
import operationexceptions.OutOfStockException;

import java.io.IOException;
import java.util.Map;

public interface CustomerOperations extends CommonOperations {
    void addProductToCart(Map<Product, Integer> companyStocks, Map<Product, Integer> customerCart, Product product, int quantity) throws OutOfStockException;
    void viewCustomerCart(Map<Product, Integer> customerCart) throws OutOfStockException;
    void buyProduct(Company company, Customer customer) throws OutOfStockException, OutOfFundException;
    void viewBoughtProducts(Map<Product, Integer> productBoughtSack);
    void generateReceipt(Customer customer, Company company) throws IOException;
    void fundWallet(double wallet, double amount) throws IncorrectPasswordException;

}
