import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUser {

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
    private WebElement insertUserame;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
    private WebElement insertPassword;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
    private WebElement save;

    @FindBy(xpath = "/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")
    private WebElement login;

    public void searchFor(String username, String password)
    {
        insertUserame.sendKeys(username);
        insertPassword.sendKeys(password);
        save.click();
        login.click();
    }

}
