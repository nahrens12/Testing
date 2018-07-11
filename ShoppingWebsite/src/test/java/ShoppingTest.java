import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class ShoppingTest {

    WebDriver driver;
    ExtentTest test;
    ExtentReports reports;




    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        reports = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Testing\\Automated_Reports_SW.html", true);
        test = reports.startTest("Automated");
    }

    @After
    public void tearDown() throws InterruptedException
    {
        Thread.sleep(3000);
      driver.quit();
        reports.endTest(test);
        reports.flush();
    }

    @Test
    public void testShoppingSite()
    {



       // driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

        Home home = PageFactory.initElements(driver, Home.class);
        home.searchForItem("Dress");
        test.log(LogStatus.INFO, "Dresses Have Been Returned");
        test.log(LogStatus.PASS, "7 results displayed");

        Dresses dresses = PageFactory.initElements(driver, Dresses.class);
        dresses.clickOn();


        SpecificDress dress = PageFactory.initElements(driver, SpecificDress.class);
        dress.clickOnCart();
        test.log(LogStatus.INFO, "Item has been added to cart");
        test.log(LogStatus.PASS, "Successful");
        //assertEquals("7 results have been found.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText());







    }


}
