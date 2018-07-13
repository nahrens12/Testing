import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/a")
    private WebElement pim;

 @FindBy(xpath = "//*[@id=\"menu_pim_addEmployee\"]")
private WebElement addEmployee;

    @FindBy(xpath = "//*[@id=\"menu_pim_viewEmployeeList\"]")
    private WebElement employeeList;

    public void homePage()
    {
        pim.click();
    }

    public void homePage2()

    {
        addEmployee.click();
    }

    public void homePage3()
    {
        employeeList.click();
    }

}
