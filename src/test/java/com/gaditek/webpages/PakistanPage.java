package com.gaditek.webpages;
import com.gaditek.configs.Configuration;
import org.apache.log4j.BasicConfigurator;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.sql.DriverManager;
import java.util.List;

import org.apache.log4j.Logger;
public class PakistanPage {
    final static Logger log = Logger.getLogger(PakistanPage.class);
    WebDriver driver;

    public PakistanPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(id= Configuration.contentID)
    private WebElement contentID;


    public String getAllParagraphsText() throws InterruptedException {
        //pTag
        Thread.sleep(5000);
         //List<WebElement> paraList = contentID.findElements(By.tagName("p"));
        List<WebElement> paraList = contentID.findElements(Configuration.pTag);
         log.debug("size is :"+paraList.size());
        Thread.sleep(1000);
        return paraList.get(1).getText();
    }
}
