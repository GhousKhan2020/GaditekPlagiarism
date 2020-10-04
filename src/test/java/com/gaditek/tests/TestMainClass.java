package com.gaditek.tests;

import com.gaditek.configs.Configuration;
import com.gaditek.webpages.PakistanPage;
import com.gaditek.webpages.PlagiarsimPage;
import com.google.common.collect.Lists;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestMainClass {
   final static Logger log = Logger.getLogger(TestMainClass.class);
    public static void main(String args[])
    {

        try {

//            String expectedText="83%\nPlagiarized";


            String paragraphText="";
            String actualText="";
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
            WebDriver chromeDriver = new ChromeDriver();
            chromeDriver.get(Configuration.wikipediaPakistanURL);
            chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            PakistanPage pp = PageFactory.initElements(chromeDriver, PakistanPage.class);

            PlagiarsimPage plagpage = PageFactory.initElements(chromeDriver, PlagiarsimPage.class);
            paragraphText = pp.getAllParagraphsText();
            chromeDriver.get(Configuration.plagarismURL);
            plagpage.writeTextOnTextArea(paragraphText);
            plagpage.clickCheckButton();
            actualText = plagpage.getPlagrizedContent();
            Assert.assertEquals("text not equal",actualText, Configuration.expectedText);
            chromeDriver.close();
              chromeDriver.quit();
        }
        catch (Exception e)
        {
       log.debug(e.getStackTrace());
            System.out.println(e.getStackTrace());
        }

    }
}
