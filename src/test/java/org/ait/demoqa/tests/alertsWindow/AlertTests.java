package org.ait.demoqa.tests.alertsWindow;

import org.ait.demoqa.pages.alertsFrameWindows.AlertsPage;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        new HomePage(driver).getAlertsFramesWindows();

    }
    @Test
    public void acceptAlert(){
        new AlertsPage(driver).clickOnClickMe1()
                .acceptAlert();
    }
    @Test
    public void timerAlertButton(){
        new AlertsPage(driver).clickOnClickMe2()
                .acceptAlert();
    }

    @Test
    public void confirmAlertTest(){
        new AlertsPage(driver).clickOnClickMe3()
                .selectConfirm("abbrechen")
                .verifyConfirmResult("You selected Cancel");
    }

    @Test
    public void sendMessageToAlertTest(){
        new AlertsPage(driver).clickOnClickMe4()
                .enterMessageToAlert("Hello World!")
                .acceptAlert()
                .verifyPromptResult("You entered Hello World!");
    }
}
