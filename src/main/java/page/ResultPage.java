package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultPage extends BasePage {

    @FindBys({@FindBy(xpath = "//*[@id='center_column']/ul/li//div[@itemprop='offers']")})
    private List<WebElement> foundItemPrices;

    protected BasePage openPage() {
        return null;
    }

    public ResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() throws InterruptedException {
        Thread.sleep(5000);
        return driver.getTitle();
    }

    //TODO: No magic numbers
    public String getPriceFromFoundItem() {
        String s = foundItemPrices.get(0).getText();
        System.out.println(s);
        return s;
    }



}
