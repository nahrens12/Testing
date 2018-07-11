import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Home {



    @FindBy(xpath = "//*[@id=\"ui-id-2\"]")
    private WebElement tab2 ;

    @FindBy(xpath = "//*[@id=\"ui-id-3\"]")
    private WebElement tab3 ;


    public void clickingOnTab()
    {
        tab2.click();
        tab3.click();
    }



}
