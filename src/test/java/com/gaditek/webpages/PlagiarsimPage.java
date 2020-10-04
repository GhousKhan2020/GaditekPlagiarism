package com.gaditek.webpages;

import com.gaditek.configs.Configuration;
import org.apache.log4j.Logger;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PlagiarsimPage {
    final static Logger log = Logger.getLogger(PlagiarsimPage.class);
    WebDriver driver;
//    WebDriverWait wait;
    /*
    * Wait wait = new FluentWait(driver)

    .withTimeout(30, SECONDS)

    .pollingEvery(5, SECONDS)

    .ignoring(NoSuchElementException.class);*/
    public PlagiarsimPage(WebDriver driver){
        this.driver = driver;


    }

    @FindBy(xpath= Configuration.textArea)
    private WebElement textArea;

    @FindBy(id=Configuration.checkButtonId)
    private WebElement checkButton;

    @FindBy(id=Configuration.plagarizedRedBorderID)
    private WebElement plagarizedRedBorder;


    public void clickCheckButton() throws InterruptedException {
        Thread.sleep(300);
        while(!checkButton.isEnabled() && !checkButton.isDisplayed())
            Thread.sleep(100);
//        driver.manage().timeouts().wait(100L);
        checkButton.click();
    }
    public void writeTextOnTextArea(String text) throws InterruptedException {
        Thread.sleep(1000);
        textArea.click();

        textArea.sendKeys(text);
    }


    public String getPlagrizedContent() throws InterruptedException {
        Thread.sleep(10000);
        String retString="";

        WebElement counterElement = plagarizedRedBorder.findElement(Configuration.counterID);

        List<WebElement> spanTagElements = counterElement.findElements(Configuration.spanTag);
        log.debug("fist element in list is: "+counterElement.getText());
        Thread.sleep(1000);

        retString=counterElement.getText().toString();
        return  retString;
    }
}
