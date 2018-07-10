import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class DemoQATest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws InterruptedException {
        //Thread.sleep(3000);
        //  driver.quit();
    }

@Test
    public void testDemo()
{
    driver.manage().window().maximize();
    driver.get("http://demoqa.com/");



}

}