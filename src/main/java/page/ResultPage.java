package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import util.WaiterWrapperClass;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
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
//        foundItemPrices.forEach(System.out::println);
        List<Double> prices = foundItemPrices.stream()
                .map(x -> Double.valueOf(x.replace("$", "")))
                .collect(Collectors.toList());
//        prices.forEach(System.out::println);
        return prices;
    }

}


    /*

    protected final int FIRST_VISIBLE_ITEM = 1;
    protected final int PART_OF_PRICE_AFTER_DISCOUNT = 0;

    @FindBys({@FindBy(xpath = "//*[@id='center_column']/ul/li//div[@itemprop='offers']")})
    private List<WebElement> foundItems;

    protected BasePage openPage() {
        return null;
    }

    public ResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<String> getPriceFromFoundItem() throws ParseException {

        WaiterWrapperClass.waitForElement(driver, foundItems.get(FIRST_VISIBLE_ITEM));
        List<String> foundItemPrices = new ArrayList<>();
        List<String> foundItemPricesOnlyNumbers = new ArrayList<>();
        for (WebElement item : foundItems) {
            foundItemPrices.add(item.getText());
        }
        int j = 0;
        List<Double> prices = new ArrayList<>();
        for (int i = 1; i < foundItemPrices.size(); i=i+2) {
            String price = foundItemPrices.get(i).split(" ")[PART_OF_PRICE_AFTER_DISCOUNT];
            prices.add((Double) NumberFormat.getCurrencyInstance().parse(price));
            System.out.println("price is " + prices.get(j));
            System.out.println("price is " + price);
            j++;
        }
        return foundItemPricesOnlyNumbers;

    }



}

     */
