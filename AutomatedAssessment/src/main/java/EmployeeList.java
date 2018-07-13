import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeList {

    @FindBy(xpath = "//*[@id=\"menu_pim_viewEmployeeList\"]")
    private WebElement employeeList;


    public void allEmployees()
    {

        employeeList.click();
    }

}
