import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDetails {

    @FindBy(xpath = "//*[@id=\"eeo_race_ethnicity_inputfileddiv\"]/div/input")
    private WebElement ethnicity;

    @FindBy(xpath = "//*[@id=\"pimPersonalDetailsForm\"]/materializecss-decorator[8]/div/sf-decorator[2]/div/button")
    private WebElement submit;

    public void personalDetails(String Ethnicity)
    {


        ethnicity.sendKeys(Ethnicity);
        ethnicity.sendKeys(Keys.TAB);
        submit.click();
    }
}
