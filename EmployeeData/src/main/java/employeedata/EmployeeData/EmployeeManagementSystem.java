package employeedata.EmployeeData;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        AdminLogin adminLogin = new AdminLogin();
        Scanner scanner = new Scanner(System.in);

        try {
            if (!adminLogin.login(scanner)) {
                System.out.println("Exiting...");
                return;
            }

            while (true) {
                System.out.println("\nEmployee Management System");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Search Employee by Name");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                switch (choice) {
                    case 1:
                        addEmployee(scanner, employeeDAO);
                        break;
                    case 2:
                        viewEmployees(scanner, employeeDAO);
                        break;
                    case 3:
                        updateEmployee(scanner, employeeDAO);
                        break;
                    case 4:
                        deleteEmployee(scanner, employeeDAO);
                        break;
                    case 5:
                        searchEmployeeByName(scanner, employeeDAO);
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addEmployee(Scanner scanner, EmployeeDAO employeeDAO) throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter position: ");
        String position = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        if (salary < 0) {
            System.out.println("Salary must be positive.");
            return;
        }

        Employee employee = new Employee();
        employee.setName(name);
        employee.setPosition(position);
        employee.setSalary(salary);

        employeeDAO.addEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    private static void viewEmployees(Scanner scanner, EmployeeDAO employeeDAO) throws SQLException {
        List<Employee> employees = employeeDAO.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("There are no employees to show.");
        } else {
            for (Employee employee : employees) {
                System.out.printf("ID: %d, Name: %s, Position: %s, Salary: %.2f%n",
                        employee.getId(), employee.getName(), employee.getPosition(), employee.getSalary());
            }
        }
        System.out.print("Press Enter to continue...");
        scanner.nextLine(); // wait for the user to press Enter
    }

    private static void updateEmployee(Scanner scanner, EmployeeDAO employeeDAO) throws SQLException {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new position: ");
        String position = scanner.nextLine();
        System.out.print("Enter new salary: ");
        double salary = scanner.nextDouble();

        if (salary < 0) {
            System.out.println("Salary must be positive.");
            return;
        }

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setPosition(position);
        employee.setSalary(salary);

        employeeDAO.updateEmployee(employee);
        System.out.println("Employee updated successfully.");
    }

    private static void deleteEmployee(Scanner scanner, EmployeeDAO employeeDAO) throws SQLException {
        System.out.print("Enter employee name to delete: ");
        String name = scanner.nextLine();

        employeeDAO.deleteEmployee(name);
        System.out.println("Employee deleted successfully.");
    }

    private static void searchEmployeeByName(Scanner scanner, EmployeeDAO employeeDAO) throws SQLException {
        System.out.print("Enter employee name to search: ");
        String name = scanner.nextLine();

        Employee employee = employeeDAO.getEmployeeByName(name);
        if (employee != null) {
            System.out.printf("ID: %d, Name: %s, Position: %s, Salary: %.2f%n",
                    employee.getId(), employee.getName(), employee.getPosition(), employee.getSalary());
        } else {
            System.out.println("Employee not found.");
        }
    }
}
