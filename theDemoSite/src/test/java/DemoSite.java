import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class DemoSite {

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
        //driver.quit();
    }

    @Test
    public void mthodTest() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("http://thedemosite.co.uk/");

        Thread.sleep(3000);

        WebElement clickAddUser = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
        clickAddUser.click();


        WebElement inputUsername = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
        inputUsername.sendKeys("nathan");


        WebElement inputPassword = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
        inputPassword.sendKeys("hello123");

        Thread.sleep(3000);
        WebElement save = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
        save.click();


        WebElement clickAddLogin = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
        clickAddLogin.click();

        WebElement typeInUseranme = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
        typeInUseranme.sendKeys("nathan");

        WebElement typeInPassword = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
        typeInPassword.sendKeys("hello123");

        Thread.sleep(3000);

        WebElement clickTestLogIn = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
        clickTestLogIn.click();


    }

    }
