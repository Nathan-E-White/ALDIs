package com.cuc.app.scrape.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://shop.aldi.us/store/aldi/storefront
public class LocationPage {
    // No page elements added

    public LocationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
