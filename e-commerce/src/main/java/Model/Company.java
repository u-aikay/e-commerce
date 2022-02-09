package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company {
    private final String companyName, companyAddress;
    private double companyAccount;
    private int warehouseCapacity;
    private List <Customer> customerList;
    private List <Admin> staffList;
    private Map<Product, Integer> stocks;

    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public Company(String companyName, String companyAddress, int warehouseCapacity) {
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.warehouseCapacity = warehouseCapacity;
        stocks = new HashMap<Product, Integer>();
        printMissionStatement();
    }

    public String getCompanyName() {return companyName;}

    public String getCompanyAddress() {return companyAddress;}

    public int getWarehouseCapacity() {return warehouseCapacity;}

    public Map <Product, Integer> getStocks() {return stocks;}

    private void printMissionStatement () {
        try {
            fileReader = new FileReader("/Users/decagon/Desktop/e-commerce/src/main/java/mission.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            System.out.println(stringBuilder);
            bufferedReader.close();
        } catch (IOException e) {System.out.println(e);}
    }

    public void receiveMoney(double amount) {companyAccount += amount;}

}
