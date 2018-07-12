import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.*;


public class PassionateTest {

    WebDriver driver;
    ExtentTest test;
    ExtentReports reports;
    String url;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        reports = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Testing\\Automated_Reports_PT.html", true);
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

    @Given("^the correct web address$")
    public void the_correct_web_address() {

        driver.get("http://www.practiceselenium.com/");
        url = driver.getCurrentUrl();
//        assertEquals("Welcome", driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[1]/a")).getText());

    }

    @When("^I navigate to the Menu page$")
    public void i_navigate_to_the_Menu_page() {
        Home homepage = PageFactory.initElements(driver, Home.class);
        homepage.menus();
        test.log(LogStatus.INFO, "Navigated to menu Page");
        test.log(LogStatus.PASS, "Successful");

    }


    @Then("^I can browse a list of the available products\\.$")
    public void i_can_browse_a_list_of_the_available_products() {
                driver.get("http://www.practiceselenium.com/menu.html");
        Menu greenTea = PageFactory.initElements(driver, Menu.class);
        greenTea.teaMenus();
        assertEquals("Check Out", driver.getTitle());
    }

    @When("^I click the checkout button$")
    public void i_click_the_checkout_button() {
        driver.get(Constant.url2);
        Menu greenTea = PageFactory.initElements(driver, Menu.class);
        greenTea.teaMenus();
        test.log(LogStatus.INFO, "Click on Check Out button");
        test.log(LogStatus.PASS, "Successful");
    }

    @Then("^I am taken to the checkout page$")
    public void i_am_taken_to_the_checkout_page() {
        driver.get(Constant.url3);
        CheckOut checkOutTea = PageFactory.initElements(driver, CheckOut.class);
        checkOutTea.teaCheckOut("nathan@hotmailc.om", "Nathan", "5 ranger road", "Visa", "1236125", "nathan", "2424");

        assertEquals("Menu", driver.findElement(By.xpath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000450914921\"]/div/h1")).getText());
    }

}
