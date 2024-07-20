package employeedata.EmployeeData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminLogin {
    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789"; // replace with your MySQL password

    public boolean login(Scanner scanner) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            while (true) {
                System.out.print("Enter admin username: ");
                String username = scanner.nextLine();
                System.out.print("Enter admin password: ");
                String password = scanner.nextLine();

                String query = "SELECT * FROM admins WHERE username = ? AND password = ?";
                try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                    pstmt.setString(1, username);
                    pstmt.setString(2, password);
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            return true;
                        } else {
                            System.out.println("Wrong credentials. Please try again.");
                        }
                    }
                }
            }
        }
    }
}
