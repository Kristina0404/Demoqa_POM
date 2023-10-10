package org.ait.demoqa.pages;

import org.ait.demoqa.pages.alertsFrameWindows.AlertsPage;
import org.ait.demoqa.pages.alertsFrameWindows.WindowPage;
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

    public AlertsPage getAlertsFramesWindows() {
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
    @FindBy(css = ".top-card:nth-child(1)")
    WebElement elements;
    public SidePanel getElements() {
        clickWithJSExecutor(elements,0,200);
        return new SidePanel(driver);
    }
@FindBy(css = ".top-card:nth-child(4)")
WebElement widgets;
    public SidePanel getWidgets() {
        clickWithJSExecutor(widgets,0,200);
        return new SidePanel(driver);
    }
    @FindBy(css = ".top-card:nth-child(2)")
    WebElement forms;
    public SidePanel getForms() {
        clickWithJSExecutor(forms,0,200);
        return new SidePanel(driver);
    }
    @FindBy(css = ".top-card:nth-child(5)")
    WebElement interactions;
    public SidePanel getInteractions() {
        clickWithJSExecutor(interactions,0,200);
        return new SidePanel(driver);
    }
}
