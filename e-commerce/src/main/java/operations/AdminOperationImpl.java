package operations;

import Model.Product;
import operationexceptions.StockNoLongerExistException;
import operationexceptions.StoreCapacityReachedException;

import java.text.NumberFormat;
import java.util.Map;

public class AdminOperationImpl implements AdministrativeOperations {



    @Override
    public void reStock(Map<Product, Integer> companyStocks, int companyCapacity, Product product, int quantity) throws StoreCapacityReachedException {
         if (companyCapacity >= quantity)  {
            companyStocks.computeIfPresent(product, (Product, Value) ->  Value + quantity);
            companyStocks.putIfAbsent(product, quantity);
         } else throw new StoreCapacityReachedException("Warehouse Capacity Reached!");
    }


    @Override
    public void removeStock(Map<Product, Integer> companyStocks, Product product) throws StockNoLongerExistException {
         if (companyStocks.containsKey(product))  {companyStocks.remove(product);
         } else throw new StockNoLongerExistException(product.getProductName() + " no longer exist!");
    }

    @Override
    public void receivePayments() {

    }
}