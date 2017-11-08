package database;

import model.Employee;
import model.Department;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBExecutor {
    private DBWorker worker;
    private Statement statement;

    private final String GET_ALL_FROM_DEPARTMENT = "SELECT * FROM DEPARTMENT";
    private final String GET_ALL_FROM_EMPLOYEE = "SELECT * FROM EMPLOYEE";

    /**
     * @throws SQLException
     */
    public DBExecutor() throws SQLException {
        worker = new DBWorker();
        statement = worker.getConnection().createStatement();
    }

    /**
     * Returns set of DB table "department" data
     *
     * @return ArrayList departmentsList
     */
    public List<Department> getDataListFromDepartment() {
        List<Department> departmentsList = new ArrayList<Department>();

        try {
            ResultSet resultSet = statement.executeQuery(GET_ALL_FROM_DEPARTMENT);

            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt(1));
                department.setName(resultSet.getString(2));

                departmentsList.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departmentsList;
    }

    /**
     * Returns set of DB table "employee" dat
     *
     * @return ArrayList employeesList
     */
    public List<Employee> getDataListFromEmployee() {
        List<Employee> employeesList = new ArrayList<Employee>();

        try {
            ResultSet resultSet = statement.executeQuery(GET_ALL_FROM_EMPLOYEE);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setDepartmentId(resultSet.getInt(2));
                employee.setChiefId(resultSet.getInt(3));
                employee.setName(resultSet.getString(4));
                employee.setSalary(resultSet.getInt(5));

                employeesList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employeesList;
    }

}