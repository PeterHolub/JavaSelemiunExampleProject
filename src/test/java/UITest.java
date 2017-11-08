import database.DBExecutor;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import model.Employee;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.MainPageObject;

import java.sql.SQLException;
import java.util.List;

public class UITest {

    private WebDriver driver;
    private MainPageObject mainPage;
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

        mainPage = new MainPageObject(driver);
        List<Employee> dBEmployeesList = new DBExecutor().getDataListFromEmployee();
        List<Employee> uIEmployeesList = mainPage.getEmployeesList();

        for (int i = 0; i < dBEmployeesList.size(); i++) {
            Employee dBEmployee = dBEmployeesList.get(i);
            Employee uIEmployee = uIEmployeesList.get(i);

            Assert.assertTrue(dBEmployee.equals(uIEmployee),
                    "Entity from DB with id=" + dBEmployee.getId() + " is not equal to UI entity");
        }
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
