import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dresses {

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
    private WebElement clickOnDress;



    public void clickOn()
    {
        clickOnDress.click();

    }


}
