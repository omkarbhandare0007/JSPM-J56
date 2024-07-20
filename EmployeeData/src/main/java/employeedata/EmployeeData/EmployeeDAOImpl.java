package employeedata.EmployeeData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";
    private static final String PASSWORD = "123456789"; // replace with your MySQL password

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void addEmployee(Employee employee) throws SQLException {
        String query = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPosition());
            pstmt.setDouble(3, employee.getSalary());
            pstmt.executeUpdate();
        }
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees ORDER BY name";
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setPosition(rs.getString("position"));
                employee.setSalary(rs.getDouble("salary"));
                employees.add(employee);
            }
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        String query = "UPDATE employees SET name = ?, position = ?, salary = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getPosition());
            pstmt.setDouble(3, employee.getSalary());
            pstmt.setInt(4, employee.getId());
            pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteEmployee(String name) throws SQLException {
        String query = "DELETE FROM employees WHERE name = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }
    }

    @Override
    public Employee getEmployeeByName(String name) throws SQLException {
        Employee employee = null;
        String query = "SELECT * FROM employees WHERE name = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    employee = new Employee();
                    employee.setId(rs.getInt("id"));
                    employee.setName(rs.getString("name"));
                    employee.setPosition(rs.getString("position"));
                    employee.setSalary(rs.getDouble("salary"));
                }
            }
        }
        return employee;
    }
}