package Day7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task2 {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "Harini195";

        String insertSQL = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

            //  student data
            String studentName = "Harini";
            int studentAge = 21;
            String studentEmail = "harini@example.com";

            // Set values for placeholders
            pstmt.setString(1, studentName);
            pstmt.setInt(2, studentAge);
            pstmt.setString(3, studentEmail);

            // Execute the insert
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Student inserted successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Error inserting student data!");
            e.printStackTrace();
        }
    }
}
