import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Employee {

    @FindBy(xpath = "//*[@id=\"employeeListTable\"]/tbody/tr/td[3]")
    private WebElement clickSelectedEmployee;

    public void foundEmployee()
    {
        clickSelectedEmployee.click();

    }

}
