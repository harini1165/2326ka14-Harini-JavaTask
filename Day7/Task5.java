package Day7;

import java.sql.*;
import java.util.Scanner;

public class Task5 {

    // JDBC connection info
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/inventorydb";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "Harini195"; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Inventory App ===");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product by Name");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addProduct(scanner);
                case 2 -> viewAllProducts();
                case 3 -> searchProductByName(scanner);
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        String sql = "INSERT INTO products (name, quantity, price) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setInt(2, quantity);
            stmt.setDouble(3, price);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Product added successfully!");
            }

        } catch (SQLException e) {
            System.out.println(" Failed to add product.");
            e.printStackTrace();
        }
    }

    private static void viewAllProducts() {
        String sql = "SELECT * FROM products";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Product List ---");

            boolean found = false;
            while (rs.next()) {
                found = true;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                System.out.printf("ID: %d | Name: %s | Quantity: %d | Price: %.2f%n",
                        id, name, quantity, price);
            }

            if (!found) {
                System.out.println("No products found.");
            }

        } catch (SQLException e) {
            System.out.println("Failed to retrieve products.");
            e.printStackTrace();
        }
    }

    private static void searchProductByName(Scanner scanner) {
        System.out.print("Enter product name to search: ");
        String keyword = scanner.nextLine();

        String sql = "SELECT * FROM products WHERE name LIKE ?";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            System.out.println("\n--- Search Results ---");

            boolean found = false;
            while (rs.next()) {
                found = true;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                System.out.printf("ID: %d | Name: %s | Quantity: %d | Price: %.2f%n",
                        id, name, quantity, price);
            }

            if (!found) {
                System.out.println("No products matched your search.");
            }

        } catch (SQLException e) {
            System.out.println(" Failed to search products.");
            e.printStackTrace();
        }
    }
}

