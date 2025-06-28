package Day7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Task3 {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "Harini195";

        String selectSQL = "SELECT id, name, age, email FROM students";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            System.out.println("Student Data:");
            System.out.println("-------------------------");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");

                System.out.printf("ID: %d | Name: %s | Age: %d | Email: %s%n", id, name, age, email);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching student data!");
            e.printStackTrace();
        }
    }
}


/*mysql> CREATE TABLE students (
	    ->     id INT AUTO_INCREMENT PRIMARY KEY,
	    ->     name VARCHAR(100),
	    ->     age INT,
	    ->     email VARCHAR(100)
	    -> );
	    
	    mysql> INSERT INTO students (name, age, email)
    -> VALUES
    ->   ('Abi', 20, 'abi@example.com'),
    ->   ('Harini', 22, 'harini@example.com');
*/