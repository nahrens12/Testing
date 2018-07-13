import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {

@FindBy(xpath = "//*[@id=\"txtUsername\"]")
    private WebElement user;

    @FindBy(xpath = "//*[@id=\"txtPassword\"]")
    private WebElement pass;

    @FindBy(xpath = "//*[@id=\"btnLogin\"]")
    private WebElement submit;


    public void logInPage(String username, String password)
    {
        user.sendKeys(username);
        pass.sendKeys(password);
        submit.click();

    }

}
