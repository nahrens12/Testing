import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Pa;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static com.relevantcodes.extentreports.LogStatus.INFO;

public class OrangeHrmTest {

    WebDriver driver;
    ExtentTest test;
    ExtentReports reports;
    String url;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        reports = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Testing\\Automated_Reports_OrangeHRM.html", true);
        test = reports.startTest("Automated");

    }
    @After
    public void tearDown()
    {
        try {
            Thread.sleep(3000);
        }catch (Exception e){

        }
        driver.quit();
        reports.endTest(test);
        reports.flush();
    }

    @Given("^the login page$")
    public void the_login_page()  {
        // Write code here that turns the phrase above into concrete actions
        driver.get(Constant.loginPage);
        url = driver.getCurrentUrl();
    }

    @When("^I login$")
    public void i_login() {
        // Write code here that turns the phrase above into concrete actions
        driver.get(Constant.loginPage);
        AdminLoginPage login = PageFactory.initElements(driver, AdminLoginPage.class);
        login.logInPage("Admin", "AdminAdmin");
        test.log(LogStatus.INFO, "Logged In");
        test.log(LogStatus.PASS, "Success");


    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab()  {
        // Write code here that turns the phrase above into concrete actions
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.homePage();
        test.log(LogStatus.INFO, "Clicked on the PIM Tab");
        test.log(LogStatus.PASS, "On the PIM Tab");
    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab() throws InterruptedException{
        // Write code here that turns the phrase above into concrete actions
        driver.get(Constant.pim);
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.homePage2();
        Thread.sleep(3000);
        test.log(LogStatus.INFO, "Adding Employee");

    }

    @When("^I fill out the Employee Details correctly$")
    public void i_fill_out_the_Employee_Details_correctly()  {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://qa-trials641.orangehrmlive.com/client/#/pim/employees");
        WebElement timeOut = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        EmployeeDetails employee = PageFactory.initElements(driver, EmployeeDetails.class);
        employee.creatingNewEmployee("Andrew", "Ronaldo", "Freitas", "113322", "France Regional");
        test.log(LogStatus.INFO, "Employee Information has been filled out");
        
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button() {
        // Write code here that turns the phrase above into concrete actions

        EmployeeDetails employee = PageFactory.initElements(driver, EmployeeDetails.class);
        employee.createNewEmployeeLogin();
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() {
        // Write code here that turns the phrase above into concrete actions
        EmployeeDetails employee = PageFactory.initElements(driver, EmployeeDetails.class);
        employee.addNewEmployeeLogin("Andrew456", "Shery125", "Shery125");
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button()  throws InterruptedException{
        // Write code here that turns the phrase above into concrete actions
//        PersonalDetails details = PageFactory.initElements(driver, PersonalDetails.class);
//        details.personalDetails("White");
        EmployeeDetails employee = PageFactory.initElements(driver, EmployeeDetails.class);
        employee.saveEmployeeLogin();
        Thread.sleep(5000);

    }
    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() throws InterruptedException {
        driver.get(Constant.pim);
        HomePage home = PageFactory.initElements(driver, HomePage.class);
        home.homePage3();

        SearchEmployeeList employees = PageFactory.initElements(driver, SearchEmployeeList.class);
        employees.searchEmployee("Andrew Freitas");

        employees.findEmployee();





    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Employee employ = PageFactory.initElements(driver, Employee.class);
        employ.foundEmployee();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://qa-trials641.orangehrmlive.com/client/#/pim/employees/133/personal_details");
        WebElement timeOut = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        PersonalDetails personal = PageFactory.initElements(driver, PersonalDetails.class);
        personal.personalDetails("White");

    }




}
