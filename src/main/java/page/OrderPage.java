package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage extends BasePage{
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        return null;
    }

    public void proceedToCheckout() {
        WebElement proceedToCheckoutButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")));
        jsClickElement(proceedToCheckoutButton);
    }
    public void proceedToCheckout2() {
        WebElement proceedToCheckoutButton2 = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//p/button[@type='submit']")));
        jsClickElement(proceedToCheckoutButton2);
    }

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

    public void payByBankWire() {
        WebElement payByBankButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//p/a[@class='bankwire']")));
        jsClickElement(payByBankButton);
    }

    public void confirmOrder() {
        WebElement confirmOrderButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//p/button")));
        jsClickElement(confirmOrderButton);
    }
}
