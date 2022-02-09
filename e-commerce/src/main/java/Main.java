import Model.*;
import enums.*;
import operationexceptions.*;
import operations.*;

public class Main {

    public static void main(String[] args) throws StoreCapacityReachedException, OutOfStockException, OutOfFundException {
        CustomerOperationImpl customerOperations = new CustomerOperationImpl() ;
        AdminOperationImpl adminOperationImpl = new AdminOperationImpl();

        Company company = new Company("Aikay Exquisite Furniture", "2B Lekki-Phase1", 500);


        Product chair1 = new Product("Three seater set", 60_000, "Italian made", ProductColor.Red, ProductCategory.CHAIRS);
        Product chair2 = new Product("executive seater set", 75_000, "Swiss made", ProductColor.White, ProductCategory.CHAIRS);
        Product dinningSet1 = new Product("Italian Dining set", 85_000, "Success product", ProductColor.Brown, ProductCategory.DINING_SETS);
        Product dinningSet2 = new Product("Oak-wood Italian Dining set", 80_000, "Nobel product", ProductColor.Black, ProductCategory.DINING_SETS);
        Product beds1 = new Product("King-size bed set", 90_000, "Nobel product", ProductColor.Brown, ProductCategory.BEDS);
        Product beds2 = new Product("6x6 flawless comfy bed-set", 85_000, "Isioma soft touch", ProductColor.Black, ProductCategory.BEDS);
        Product table1 = new Product("Exclusive glass centre table", 50_000, "Nobel product", ProductColor.Blue, ProductCategory.TABLES);
        Product table2 = new Product("Iroko polished wood table", 50_000, "Cole fantom", ProductColor.Brown, ProductCategory.TABLES);
        Product wardrobe1 = new Product("4x4 brown polished Wardrobe", 125_000, "Aikay collection", ProductColor.Brown, ProductCategory.WARDROBES);
        Product wardrobe2 = new Product("Full wall galvanized black wardrobe", 250_000, "Dami special", ProductColor.White, ProductCategory.WARDROBES);
        Product wardrobe3 = new Product("Executive black digital wardrobe", 400_000, "Spears willers", ProductColor.Black, ProductCategory.WARDROBES);


        Customer customer1 = new Customer("Ola", "Dayo", "Lekki",  2_000_000);
        Customer customer2 = new Customer("Kemisola", "Oladayo", "Ikorodu",  1_000_000);
        Customer customer3 = new Customer("Chukwuma", "Richard", "PH",  1_500_000);
        Customer customer4 = new Customer("Peter", "Abishola", "Abuja",  700_000);

        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), chair1,30);
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), chair2,20);
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), dinningSet1,25);
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), dinningSet2,30);
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), beds1,20);
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), beds2,15);
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), table1,45);
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), table2,35);
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), wardrobe1,15);
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), wardrobe2,20);
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), wardrobe3,15);

        customerOperations.addProductToCart(company.getStocks(), customer1.getCart(), chair1, 2);
        customerOperations.addProductToCart(company.getStocks(), customer1.getCart(), wardrobe3, 3);
        customerOperations.addProductToCart(company.getStocks(), customer1.getCart(), beds1, 3);
//        customerOperations.addProductToCart(company.getStocks(), customer2.getCart(), chair2, 2);
//        customerOperations.addProductToCart(company.getStocks(), customer2.getCart(), beds2, 3);
//        customerOperations.addProductToCart(company.getStocks(), customer2.getCart(), dinningSet1, 3);
//        customerOperations.addProductToCart(company.getStocks(), customer3.getCart(), wardrobe1, 3);
//        customerOperations.addProductToCart(company.getStocks(), customer3.getCart(), dinningSet2, 3);
//        customerOperations.addProductToCart(company.getStocks(), customer3.getCart(), table1, 3);
//        customerOperations.addProductToCart(company.getStocks(), customer4.getCart(), table2, 3);
//        customerOperations.addProductToCart(company.getStocks(), customer4.getCart(), wardrobe2, 3);
//
        customerOperations.buyProduct(company, customer1);
        customerOperations.viewProductByCategory(company.getStocks(), ProductCategory.CHAIRS);
//        customerOperations.buyProduct(company, customer2);
//        customerOperations.buyProduct(company, customer3);
//        customerOperations.buyProduct(company, customer4);
////
//
//
//        customerOperations.viewBoughtProducts(customer1.getProductBoughtStack());
//        customerOperations.viewBoughtProducts(customer2.getProductBoughtStack());
//        customerOperations.viewBoughtProducts(customer3.getProductBoughtStack());
//        customerOperations.viewBoughtProducts(customer4.getProductBoughtStack());
        }



}
