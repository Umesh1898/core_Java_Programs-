import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exception1 {
    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double productPrice = scanner.nextDouble();

        
        double totalPrice = productPrice + (productPrice * 0.10);

    
        try {
            writeToFile(productId, productName, totalPrice);
            System.out.println("Product information saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void writeToFile(String productId, String productName, double totalPrice) throws IOException {
        String fileName = "product_info.txt";

        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
        
            fileWriter.write("Product ID: " + productId + "\n");
            fileWriter.write("Product Name: " + productName + "\n");
            fileWriter.write("Total Price with 10% Charge: $" + String.format("%.2f", totalPrice) + "\n");
            fileWriter.write("\n");  
        }
    }
}