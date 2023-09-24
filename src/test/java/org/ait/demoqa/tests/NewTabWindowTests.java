package org.ait.demoqa.tests;

import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.WindowPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTabWindowTests extends TestBase {
    @BeforeMethod

    public void precondition() {
        new HomePage(driver).getMultipleWindows();
    }

    @Test

    public void switchToNewTabTest() {
        new WindowPage(driver).switchToNewTab(1)
                .verifyNewTabTitle("This is a sample page");
    }

    @Test
    public void switchToNewWindow() {
        new WindowPage(driver).switchToNewWindow(1)
                .verifyNewWindowTitle("This is a sample page");
    }

    @Test
    public void switchToWindowMessage() {
        new WindowPage(driver).switchToWindowMessage(1)
                .verifyWindowMessage("Knowledge increases by sharing but not by saving." +
                        " Please share this website with your friends and in your organization." +
                        "Knowledge increases by sharing but not by saving. " +
                        "Please share this website with your friends and in your organization.");
    }

}
