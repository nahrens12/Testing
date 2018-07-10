
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class newDemoSite {

    WebDriver driver;
    ExtentTest test;
    ExtentReports reports;
    String DemoData = "C:\\Users\\Admin\\IdeaProjects\\Testing\\DemoSiteDDT.xlsx";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Development/web_driver/chromedriver.exe");
        driver = new ChromeDriver();
        reports = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\Testing\\Automated_Reports.html", true);
        test = reports.startTest("Automated");


    }

    @After
    public void tearDown () throws InterruptedException
    {
        Thread.sleep(1000);
        driver.quit();
        reports.endTest(test);
        reports.flush();
    }


    @Test
    public void testDemoSite() throws IOException, InterruptedException, FileNotFoundException {

        FileInputStream file = null;
        try {
            file = new FileInputStream(Constant.Path_ExcelData + Constant.File_ExcelData);
        } catch (FileNotFoundException e) {
        }
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
        }
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFCell cell = sheet.getRow(0).getCell(0);
        //System.out.println(cell.getStringCellValue());

        for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

            XSSFCell username = sheet.getRow(i).getCell(0);
            XSSFCell password = sheet.getRow(i).getCell(1);
          //  XSSFCell result = sheet.getRow(i).getCell(2);

            String user = username.getStringCellValue();
            String pass = password.getStringCellValue();
           // String reul = result.getStringCellValue();

            driver.manage().window().maximize();
            driver.get("http://thedemosite.co.uk/");
            test.log(LogStatus.INFO, "Browser Started");

            Home homePage = PageFactory.initElements(driver, Home.class);
            homePage.addUserButton();
            test.log(LogStatus.PASS, "click on add user");

            AddUser addUser = PageFactory.initElements(driver, AddUser.class);
            addUser.searchFor(user, pass);
            Thread.sleep(2000);
            test.log(LogStatus.INFO, "Adding new user");


            Login login = PageFactory.initElements(driver, Login.class);
            login.searchFor(user, pass);
            Thread.sleep(3000);
            test.log(LogStatus.INFO, "Users have logged in");
            test.log(LogStatus.PASS, "Successful Login");

            assertEquals("**Successful Login**", driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText());
        }
    }
}




