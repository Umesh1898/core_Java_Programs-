import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Product {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double productPrice = scanner.nextDouble();

        
        double totalPrice = productPrice + (productPrice * 0.10);

        
        FileWriter fileWriter = null;
        try {
            writeToFile(productId, productName, totalPrice);
            System.out.println("Product information saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
        
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error closing FileWriter: " + e.getMessage());
                }
            }
        }
    }

    public static void writeToFile(String productId, String productName, double totalPrice) throws IOException {
        String fileName = "product_info.txt";
        FileWriter fileWriter = new FileWriter(fileName, true);

        try {
    
            fileWriter.write("Product ID: " + productId + "\n");
            fileWriter.write("Product Name: " + productName + "\n");
            fileWriter.write("Total Price with 10% Charge: $" + String.format("%.2f", totalPrice) + "\n");
            fileWriter.write("\n");  
        } finally {
            
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }
}