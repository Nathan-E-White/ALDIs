package com.cuc.app.scrape.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = about:blank
public class LoginPage {
    // No page elements added

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}