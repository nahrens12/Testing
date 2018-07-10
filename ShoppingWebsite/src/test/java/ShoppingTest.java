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

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws InterruptedException
    {
        //Thread.sleep(3000);
      //  driver.quit();
    }

    @Test
    public void testShoppingSite() throws InterruptedException
    {

        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");

        Home home = PageFactory.initElements(driver, Home.class);
        home.searchForItem("Dress");

//        Dresses dresses = PageFactory.initElements(driver, Dresses.class);
//        dresses.addToCart();
        Thread.sleep(5000);

        assertEquals("7 results have been found.", driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span[2]")).getText());






    }


}
