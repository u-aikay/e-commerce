package operations;


import Model.Product;
import enums.ProductCategory;
import operationexceptions.OutOfStockException;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public interface CommonOperations {
    Locale nigeria = new Locale ("en", "NG");
    NumberFormat formatter = NumberFormat.getCurrencyInstance(nigeria);

    default void viewAllProducts(Map<Product, Integer> stocks) throws OutOfStockException {
        String productList = viewProduct(stocks, null);
        if(!(productList.length() == 0)) {
            System.out.println("------- List Of Products Available at Aikay Exquisite Furniture -------");
            System.out.println(productList);}
        else  throw new OutOfStockException ("There are currently no products available in the warehouse.");
    };

    default void viewProductByCategory(Map<Product, Integer> stocks, ProductCategory productCategory) throws OutOfStockException {
        String productCategoryList = viewProduct(stocks, productCategory);
        if(!(productCategoryList.length() == 0)) {
            System.out.println("------- List Of Products Available at Aikay Exquisite Furniture -------");
            System.out.println(productCategoryList);}
        else throw new OutOfStockException("There are currently no products available in the " + productCategory + ".");
    }

    private String viewProduct (Map<Product, Integer> stocks,  ProductCategory productCategory){

        StringBuilder productCategoriesList = new StringBuilder();
        int serialNumber = 1;
        for (var item : stocks.entrySet()) {
            Product product = item.getKey();
            /////productCategory
            if (product.getProductCategory().equals(productCategory)) {
                productCategoriesList.append(serialNumber + " | Product name: " + product.getProductName() + " | Category: " + product.getProductCategory() + " | Quantity Available: " + item.getValue()
                        + " | " + formatter.format(product.getProductPrice()) + "\n");
                serialNumber++;
            }

            if (productCategory == null) {
                productCategoriesList.append(serialNumber + " | Product name: " + product.getProductName() + " | Category: " + product.getProductCategory() + " | Quantity Available: " + item.getValue()
                        + " | " + formatter.format(product.getProductPrice()) + "\n");
                serialNumber++;
            }
        }

        return productCategoriesList.toString();
    }

}
