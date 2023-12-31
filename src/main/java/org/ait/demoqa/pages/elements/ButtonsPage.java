package org.ait.demoqa.pages.elements;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.Duration;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickBtn;
    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;

    public ButtonsPage doubleClick() {
        pause(500);
        //Actions actions = new Actions(driver);
        // actions.doubleClick(doubleClickBtn).perform();  переменная нужна , если ею мы воспользуемся ни один раз
        new Actions(driver).doubleClick(doubleClickBtn).perform();
        return this;
    }

    public ButtonsPage assertDoubleClick(String message) {
        Assert.assertTrue(shouldHaveText(doubleClickMessage, message, 5));
        return this;
    }

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;
    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    public ButtonsPage rightClick() {
        new Actions(driver).contextClick(rightClickBtn).perform();
        return this;
    }

    public ButtonsPage assertRightClick(String message) {
        Assert.assertTrue(shouldHaveText(rightClickMessage, message, 10));
        return this;
    }
}
