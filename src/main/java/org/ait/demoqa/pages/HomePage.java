package org.ait.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".top-card:nth-child(6)")
    WebElement bookStore;

    public SidePanel getBookStore() {
        clickWithJSExecutor(bookStore, 0, 300);
        return new SidePanel(driver);
    }

    @FindBy(xpath = "//div[h5='Alerts, Frame & Windows']")
    WebElement alertsFrameCard;
    @FindBy(xpath = "//span[text()='Alerts']")
    WebElement alertSidePanel;

    public AlertsPage getAlerts() {
        clickWithJSExecutor(alertsFrameCard,500,300);
        clickWithJSExecutor(alertSidePanel,0,300);
        return new AlertsPage(driver);
    }
@FindBy(xpath = "//span[text()='Browser Windows']")
WebElement browserWindow;
    public WindowPage getMultipleWindows() {
        clickWithJSExecutor(alertsFrameCard,500,300);
        clickWithJSExecutor(browserWindow,0,250);
        return new WindowPage(driver);
    }
}
