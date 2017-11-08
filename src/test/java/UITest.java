import database.DBExecutor;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import model.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UITest {

    private WebDriver driver;
    private static final String BASE_URL = "http://benzoelectromoty.ga/qa/";

    @BeforeClass
    public static void setupClass() {
        ChromeDriverManager.getInstance().setup();
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void getUIData() throws IllegalAccessException, SQLException {
        driver.get(BASE_URL);

        List<WebElement> trList = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
        List<Employee> dBEmployeesList = new DBExecutor().getDataListFromEmployee();
        List<Employee> uIEmployeesList = new ArrayList<Employee>();

        for (int i = 0; i < trList.size(); i++) {
            List<WebElement> propsList = driver.findElements(By.xpath("/html/body/table/tbody/tr[" + i + "]/td"));
            if (propsList.size() == 5) {
                Employee employee = new Employee();

                employee.setId(Integer.parseInt(propsList.get(0).getText()));
                employee.setDepartmentId(Integer.parseInt(propsList.get(1).getText()));
                employee.setChiefId(Integer.parseInt(propsList.get(2).getText()));
                employee.setName(propsList.get(3).getText());
                employee.setSalary(Integer.parseInt(propsList.get(4).getText()));

                uIEmployeesList.add(employee);
            }
        }

        for (int i = 0; i < dBEmployeesList.size(); i++) {
            Employee dBEmployee = dBEmployeesList.get(i);
            Employee uIEmployee = uIEmployeesList.get(i);

            Assert.assertTrue(dBEmployee.equals(uIEmployee), "Entity from DB with id=" + dBEmployee.getId() + " is not equal to UI entity");
        }
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
