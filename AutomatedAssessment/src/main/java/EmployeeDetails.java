import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeDetails {
   @FindBy(xpath = "//*[@id=\"firstName\"]")
   private WebElement first;

    @FindBy(xpath = "//*[@id=\"middleName\"]")
    private WebElement middle;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    private WebElement last;

    @FindBy(xpath = "//*[@id=\"employeeId\"]")
    private WebElement id;

    @FindBy(xpath = "//*[@id=\"location_inputfileddiv\"]/div/input")
    private WebElement loc;

    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    private WebElement createLogin;

    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement userName;

    @FindBy(xpath = "//*[@id=\"status_inputfileddiv\"]/div/input")
    private WebElement status;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passWord;

    @FindBy(xpath = "//*[@id=\"confirmPassword\"]")
    private WebElement confirmPassWord;

    @FindBy(xpath = "//*[@id=\"essRoleId_inputfileddiv\"]/div/input")
    private WebElement essRole;

    @FindBy(xpath = "//*[@id=\"supervisorRoleId_inputfileddiv\"]/div/input")
    private WebElement supervisorRole;

    @FindBy(xpath = "//*[@id=\"adminRoleId_inputfileddiv\"]/div/input")
    private WebElement adminRole;

    @FindBy(xpath = "//*[@id=\"systemUserSaveBtn\"]")
    private WebElement submit;


    public void creatingNewEmployee(String firstname, String middlename, String lastName, String employeeId)
    {
        first.sendKeys(firstname);
            middle.sendKeys(middlename);
            last.sendKeys(lastName);
            id.sendKeys(employeeId);
        loc.click();
            loc.sendKeys(Keys.chord("l"));
        loc.sendKeys(Keys.ENTER);
    }


    public void createNewEmployeeLogin()
    {
        createLogin.click();
    }

    public void addNewEmployeeLogin(String username, String password, String confirmPassword) throws InterruptedException{
        userName.sendKeys(username);
        status.sendKeys(Keys.TAB);
        passWord.sendKeys(password);
        confirmPassWord.sendKeys(confirmPassword);
        essRole.sendKeys(Keys.TAB);
        supervisorRole.sendKeys(Keys.TAB);
        adminRole.sendKeys(Keys.chord("a"));
        adminRole.sendKeys(Keys.ENTER);
    }

    public void saveEmployeeLogin()
    {
        submit.click();
    }

}
