package pages;

import model.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private WebDriver driver;

    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> tableRowsList;

    public MainPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    private int getNumberOfRowsInTableInteger() {
        return this.tableRowsList.size();
    }

    public List<Employee> getEmployeesList() {
        List<Employee> employeesList = new ArrayList<Employee>();

        for (int i = 0; i < this.getNumberOfRowsInTableInteger(); i++) {
            List<WebElement> propsList = driver.findElements(By.xpath("/html/body/table/tbody/tr[" + i + "]/td"));

            if (propsList.size() == 5) {
                Employee employee = new Employee();

                employee.setId(Integer.parseInt(propsList.get(0).getText()));
                employee.setDepartmentId(Integer.parseInt(propsList.get(1).getText()));
                employee.setChiefId(Integer.parseInt(propsList.get(2).getText()));
                employee.setName(propsList.get(3).getText());
                employee.setSalary(Integer.parseInt(propsList.get(4).getText()));

                employeesList.add(employee);
            }
        }
        return employeesList;
    }
}
