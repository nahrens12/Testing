import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class DemoQATest {

    WebDriver driver;
    ExtentTest test;
    ExtentReports reports;
    Actions action;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        reports = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Testing\\Automated_Reports_DemoQA.html", true);
        test = reports.startTest("Automated");

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

@Test
    public void testDemo()
{
    driver.manage().window().maximize();
    driver.get("http://demoqa.com/");

    Home homePage = PageFactory.initElements(driver, Home.class);
    homePage.clickingOnTab();
    //dragMeAround = driver.findElement(By.xpath("//*[@id=\"ui-id-3\"]"));
   // action.moveToElement().moveByOffset();
    test.log(LogStatus.PASS, "click on add user");


}

}