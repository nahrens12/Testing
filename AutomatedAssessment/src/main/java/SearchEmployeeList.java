import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchEmployeeList {

    @FindBy(xpath = "//*[@id=\"employee_name_quick_filter_employee_list_value\"]")
    private WebElement search;

    @FindBy(xpath = "//*[@id=\"quick_search_icon\"]")
    private WebElement go;
    public void searchEmployee(String name)
    {

        search.sendKeys(name);
        search.sendKeys(Keys.TAB);
        search.click();
    }

    public void findEmployee()
    {
        go.click();

    }
}
