import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class GoogleTest {

    WebDriver driver;

    @Before
public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
       // driver.quit();
    }

    @Test
    public void mthodTest()
    {
        driver.manage().window().maximize();
        driver.get("http://www.google.co.uk");

        WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));

        checkElement.sendKeys("hello");

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]"));
        searchButton.click();

        WebElement clickAnother = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div[1]/a/span"));
        clickAnother.click();
       // assertEquals("hello", checkElement.getText());



    }



}
