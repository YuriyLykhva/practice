package page;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class ControlPage extends BasePage{

    public ControlPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        return null;
    }

    public String getAlertHeader() {
        log.info("Get alert header method started");
        WebElement alertHeaderText = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='alert alert-danger']/p")));
        return alertHeaderText.getText();
    }

}


