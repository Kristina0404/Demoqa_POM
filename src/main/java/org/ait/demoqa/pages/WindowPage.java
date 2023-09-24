package org.ait.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class WindowPage extends BasePage {
    public WindowPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='tabButton']")
    WebElement newTab;

    public WindowPage switchToNewTab(int index) {
        click(newTab);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(xpath = "//h1[@id='sampleHeading']")
    WebElement newTabResult;

    public WindowPage verifyNewTabTitle(String text) {
        Assert.assertTrue(shouldHaveText(newTabResult, text, 5));
        return this;
    }

    @FindBy(xpath = "//button[@id='windowButton']")
    WebElement newWindow;

    public WindowPage switchToNewWindow(int index) {
        click(newWindow);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(xpath = "//h1[@id='sampleHeading']")
    WebElement newWindowResult;

    public WindowPage verifyNewWindowTitle(String text) {
        Assert.assertTrue(shouldHaveText(newWindowResult, text, 5));
        return this;
    }

    @FindBy(xpath = "//button[@id='messageWindowButton']")
    WebElement windowMessage;

    public WindowPage switchToWindowMessage(int index) {
        click(windowMessage);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(xpath = "//body")
    WebElement message;

    public WindowPage verifyWindowMessage(String text) {

        Assert.assertNotNull(message);

        return this;
    }
}
