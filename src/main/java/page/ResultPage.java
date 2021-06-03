package page;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import util.WaiterWrapperClass;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ResultPage extends BasePage {

    /**
     * Variables, constants
     */
    private final String productPriceXpath =
            "//div[@class='right-block']//span[@class='price product-price']";

    /**
     * Web Elements
     */
    @FindBys({@FindBy(xpath = productPriceXpath)})
    private List<WebElement> foundItems;

    /**
     * Implementation of BasePage method
     * @return null
     */
    protected BasePage openPage() {
        return null;
    }

    /**
     * Receiving driver for the page
     * @param driver should be passed here
     */
    public ResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Collecting the prices of found products
     * @return List of prices of found products
     */
    @Step("Return prices")
    public List<Double> getPriceFromFoundItem() {
        log.info("Get prices method started");
        WaiterWrapperClass.waitForElementLocatedBy(driver, By.xpath(productPriceXpath));
        List<String> foundItemPrices = foundItems.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        List<Double> prices = foundItemPrices.stream()
                .map(x -> Double.valueOf(x.replace("$", "")))
                .collect(Collectors.toList());
        log.info("Prices return");
        return prices;
    }

}


