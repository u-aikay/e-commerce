package operations;

import Model.Product;
import operationexceptions.StockNoLongerExistException;
import operationexceptions.StoreCapacityReachedException;

import java.util.Map;

public interface AdministrativeOperations extends CommonOperations {
    void reStock(Map <Product, Integer> companyStocks, int companyCapacity, Product product, int quantity) throws StoreCapacityReachedException;
    void removeStock(Map<Product, Integer> companyStocks, Product product) throws StockNoLongerExistException;
    void receivePayments();
}
