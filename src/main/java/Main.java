import database.DBWorker;
import model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        String GET_ALL_FROM_EMPLOYEE = "SELECT * FROM EMPLOYEE";
        String GET_ALL_FROM_DEPARTMENT = "SELECT * FROM DEPARTMENT";

        DBWorker worker = new DBWorker();

        Statement statement = worker.getConnection().createStatement();

//        try {
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//                Department department = new Department();
//                department.setId(resultSet.getInt(1));
//                department.setName(resultSet.getString(2));
//
//                System.out.println(department);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try {
            ResultSet resultSet = statement.executeQuery(GET_ALL_FROM_EMPLOYEE);

            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setDepartmentId(resultSet.getInt(2));
                employee.setChiefId(resultSet.getInt(3));
                employee.setName(resultSet.getString(4));
                employee.setSalary(resultSet.getInt(5));

                System.out.println(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
