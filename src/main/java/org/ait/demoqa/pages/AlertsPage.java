package org.ait.demoqa.pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends HomePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='alertButton']")
    WebElement alertButton;

    public AlertsPage clickOnClickMe1() {
        click(alertButton);
        return this;
    }

    public AlertsPage acceptAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (NoAlertPresentException ex) {
        }
        return this;
    }

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    WebElement timerAlertButton;

    public AlertsPage clickOnClickMe2() {
        click(timerAlertButton);
        return this;
    }

    @FindBy(xpath = "//button[@id='confirmButton']")
    WebElement confirmButton;

    public AlertsPage clickOnClickMe3() {
        click(confirmButton);
        return this;
    }

    public AlertsPage selectConfirm(String confirm) {
        if(confirm!= null && confirm.equalsIgnoreCase("ok")){
            driver.switchTo().alert().accept();
        }else if (confirm!=null && confirm.equalsIgnoreCase("abbrechen")){
            driver.switchTo().alert().dismiss();
        }
        return this;
    }
    @FindBy(xpath = "//span[@id='confirmResult']")
    WebElement result;

    public AlertsPage verifyConfirmResult(String message) {
        Assert.assertTrue(shouldHaveText(result, message,5));

        return this;
    }
 @FindBy(xpath = "//button[@id='promtButton']")
 WebElement promptButton;
    public AlertsPage clickOnClickMe4() {
        clickWithJSExecutor(promptButton,500,300);
        return this;
    }

    public AlertsPage enterMessageToAlert(String message) {
        if(message!= null){
            driver.switchTo().alert().sendKeys(message);
        }
        return this;
    }
@FindBy(xpath = "//span[@id='promptResult']")
WebElement promptResult;
    public AlertsPage verifyPromptResult(String message) {
        Assert.assertTrue(shouldHaveText(promptResult, message, 5));

        return this;
    }

}
