import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpecificDress {


    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
    private WebElement addTocart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    private WebElement proceedToCheckOut;

    public void clickOnCart() {

        addTocart.click();
        proceedToCheckOut.click();
    }
}