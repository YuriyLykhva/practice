package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage extends BasePage{

    /**
     * Receiving driver for the page
     * @param driver should be passed here
     */
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Implementation of BasePage method
     * @return null
     */
    @Override
    protected BasePage openPage() {
        return null;
    }

    /**
     * Clicking the Checkout button on 1st step
     */
    public void proceedToCheckout() {
        WebElement proceedToCheckoutButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")));
        jsClickElement(proceedToCheckoutButton);
    }

    /**
     * Clicking the Checkout button on 2nd step
     */
    public void proceedToCheckout2() {
        WebElement proceedToCheckoutButton2 = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//p/button[@type='submit']")));
        jsClickElement(proceedToCheckoutButton2);
    }

    /**
     * Clicking the Checkout button on 3rd step
     */
    public void proceedToCheckout3() {
        WebElement checkbox = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//input[@type='checkbox']")));
        jsClickElement(checkbox);
        WebElement proceedToCheckoutButton3 = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//button[@name='processCarrier']")));
        jsClickElement(proceedToCheckoutButton3);
    }

    /**
     * Choosing the payment option
     */
    public void payByBankWire() {
        WebElement payByBankButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//p/a[@class='bankwire']")));
        jsClickElement(payByBankButton);
    }

    /**
     * Clicking the Confirm Order button
     */
    public void confirmOrder() {
        WebElement confirmOrderButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//p/button")));
        jsClickElement(confirmOrderButton);
    }
}
