package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import util.WaiterWrapperClass;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends BasePage {

    private final String productPriceXpath = "//div[@class='right-block']//span[@class='price product-price']";

    @FindBys({@FindBy(xpath = productPriceXpath)})
    private List<WebElement> foundItems;

    protected BasePage openPage() {
        return null;
    }
    public ResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public List<Double> getPriceFromFoundItem() {
        WaiterWrapperClass.waitForElementLocatedBy(driver, By.xpath(productPriceXpath));
        List<String> foundItemPrices = foundItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        List<Double> prices = foundItemPrices.stream()
                .map(x -> Double.valueOf(x.replace("$", "")))
                .collect(Collectors.toList());
        return prices;
    }

}


