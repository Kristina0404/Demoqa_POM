package org.ait.demoqa.pages.elements;

import org.ait.demoqa.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public TextBoxPage keyBoardEvent(String text) {
        typeWithJSExecutor(currentAddress, text, 0, 100);
        Actions actions = new Actions(driver);
        // select current address
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        // copy current address
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        //press TAB KYe to switch focus to permanent address
        actions.sendKeys(Keys.TAB).perform();
        //past current address in permanent address field
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        return this;
    }

    @FindBy(id = "permanentAddress")
    WebElement permanentAddress;
    @FindBy(id = "submit")
    WebElement submitBtn;

    public TextBoxPage assertCopyPastText(String text) {
    if(currentAddress != null && permanentAddress!=null){
      clickWithJSExecutor(submitBtn,0,400);
        String currentAddressValue = currentAddress.getText();
        String permanentAddressValue = permanentAddress.getText();
        Assert.assertEquals(currentAddressValue,permanentAddressValue);
    }
        return this;
    }


}
