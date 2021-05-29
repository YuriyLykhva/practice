package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ControlPage extends BasePage{

    public ControlPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        return null;
    }

    public String getAlertHeader() {
        WebElement alertHeaderText = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='alert alert-danger']/p")));
        return alertHeaderText.getText();
    }

//    public ControlPage registerButtonClick() {
//        WebElement button1 = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
//                .until(ExpectedConditions.presenceOfElementLocated(By
//                        .xpath("//button[@id='submitAccount']")));
//        jsClickElement(button1);
//        return new ControlPage(driver);
//    }
}


