import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOut {

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement name;

    @FindBy(xpath = "//*[@id=\"address\"]")
    private WebElement address;

    @FindBy(xpath = "//*[@id=\"card_type\"]")
    private WebElement cardType;
    @FindBy(xpath = "//*[@id=\"card_number\"]")
    private WebElement cardNumber;
    @FindBy(xpath = "//*[@id=\"cardholder_name\"]")
    private WebElement cardHolder;
    @FindBy(xpath = "//*[@id=\"verification_code\"]")
    private WebElement verification;

    @FindBy(xpath = "//*[@id=\"wsb-element-00000000-0000-0000-0000-000452010925\"]/div/div/form/div/button")
    private WebElement placeOrder;


    public void teaCheckOut(String text, String text2, String text3,String text7, String text4, String text5, String text6)
    {
        email.sendKeys(text);
        name.sendKeys(text2);
        address.sendKeys(text3);
        cardType.sendKeys(text7);
        cardType.sendKeys(Keys.TAB);
        cardNumber.sendKeys(text4);
        cardHolder.sendKeys(text5);
        verification.sendKeys(text6);
        placeOrder.click();
    }
}
