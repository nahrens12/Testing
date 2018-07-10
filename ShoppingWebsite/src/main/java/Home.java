import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {

        @FindBy(xpath = "//*[@id=\"search_query_top\"]")
        private WebElement searchForItem;

        @FindBy(xpath = "//*[@id=\"searchbox\"]/button")
        private WebElement clickSearchButton;

        public void searchForItem(String search)

        {
            searchForItem.sendKeys(search);
            clickSearchButton.click();

        }

    }


