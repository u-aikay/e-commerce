package operations;

import Model.*;
import enums.*;
import junit.framework.TestCase;
import operationexceptions.OutOfFundException;
import operationexceptions.OutOfStockException;
import operationexceptions.StoreCapacityReachedException;
import org.junit.Assert;

import static org.junit.Assert.assertThrows;

public class CustomerOperationImplTest extends TestCase {
    CustomerOperationImpl customerOperations = new CustomerOperationImpl() ;
    AdminOperationImpl adminOperationImpl = new AdminOperationImpl();

    Product chair1 = new Product("Three seater set", 60_000, "Italian made", ProductColor.Red, ProductCategory.CHAIRS);
    Product chair2 = new Product("executive seater set", 75_000, "Swiss made", ProductColor.White, ProductCategory.CHAIRS);

    Customer customer2 = new Customer("Kemisola", "Oladayo", "Ikorodu",  1_000_000);

    Company company = new Company("Aikay Exquisite Furnitures", "2B Lekki-Phase1", 500);




    public void testForEmptyCustomerCart (){
        Assert.assertTrue(customer2.getCart().isEmpty());
    }

    public  void testStockingWareHouse () throws StoreCapacityReachedException {
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), chair2,20);
        Assert.assertTrue(company.getStocks().keySet().contains(chair2));
    }

    public  void testOverStockingWareHouse() throws StoreCapacityReachedException {
        Exception exception = assertThrows(StoreCapacityReachedException.class, () -> {
            adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), chair1, 600);
        });
        assertTrue("Warehouse Capacity Reached!".contains(exception.getMessage()));
    }

    public  void testForCustomerFillingCart() throws OutOfStockException, StoreCapacityReachedException {
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), chair2,20);
        customerOperations.addProductToCart(company.getStocks(), customer2.getCart(), chair2, 5);
        Assert.assertTrue("Test for Product in Cart!", customer2.getCart().keySet().contains(chair2));
        Assert.assertTrue("Test for Quantity of Product!", customer2.getCart().get(chair2).equals(5));
    }


    public void testForBuyingProductInCart() throws StoreCapacityReachedException, OutOfStockException, OutOfFundException {
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), chair1, 30);
        customerOperations.addProductToCart(company.getStocks(), customer2.getCart(),chair1, 5);
        customerOperations.buyProduct(company, customer2);
        Assert.assertTrue("Test For Empty Cart After Purchase, Cart should be empty after purchase!", customer2.getCart().isEmpty());
        Assert.assertTrue("Test For Product In BoughtStack After Purchase!", customer2.getProductBoughtStack().containsKey(chair1));

    }

    public  void testForBuyingEmptyCart() throws OutOfStockException, StoreCapacityReachedException {
        adminOperationImpl.reStock(company.getStocks(), company.getWarehouseCapacity(), chair2,20);
        customerOperations.addProductToCart(company.getStocks(), customer2.getCart(), chair2, 5);
        Assert.assertTrue("Test for Product in Cart!", customer2.getCart().keySet().contains(chair2));
        Assert.assertTrue("Test for Quantity of Product!", customer2.getCart().get(chair2).equals(5));
    }

public void testException () {
    Exception exception = assertThrows(NumberFormatException.class, () -> {
        Integer.parseInt("1a");
    });
    String expectedMessage = "For input string";
    String actualMessage = exception.getMessage();
    assertTrue(actualMessage.contains(expectedMessage));
}

    public void testBuyProduct() {
    }

    public void testGenerateReceipt() {
    }
}