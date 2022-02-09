package Model;

import enums.ProductCategory;
import enums.ProductColor;

public class Product {
    private String productName, productDescription;
    private int productQuantity;
    private double productPrice;
    private ProductCategory productCategory;
    private ProductColor productColor;



    public Product(String productName, double productPrice, String productDescription, ProductColor productColor, ProductCategory productCategory) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productColor = productColor;
        this.productCategory = productCategory;

    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public ProductColor getProductColor() {
        return productColor;
    }

}
