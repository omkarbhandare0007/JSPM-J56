package employeedata.EmployeeData;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee) throws SQLException;
    List<Employee> getAllEmployees() throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    void deleteEmployee(String name) throws SQLException;
    Employee getEmployeeByName(String name) throws SQLException;
}
