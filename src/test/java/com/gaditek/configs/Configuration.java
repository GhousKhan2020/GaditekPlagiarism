package com.gaditek.configs;

import org.openqa.selenium.By;

public class Configuration {

    public static final String wikipediaPakistanURL="https://en.wikipedia.org/wiki/Pakistan";
    public static final String plagarismURL="https://plagiarismdetector.net/";
    public static final String contentID="mw-content-text";
    public static final By pTag = By.tagName("p");
//   public static final String textArea = "/html/body/div[8]/div/div[2]/div[4]/form/div[1]/textarea";
    public static final String textArea = "/html/body/div[8]/div/div[2]/div[4]/form/div[1]/textarea";

    //#form > div.form-group.mb-0
    public static final String checkButtonId ="check";

    public static final String plagarizedRedBorderID="id_here2";
    public static final By counterID = By.id("counter");
    public static final By spanTag = By.tagName("span");
    public static final  String expectedText="83%\nPlagiarized";
}
