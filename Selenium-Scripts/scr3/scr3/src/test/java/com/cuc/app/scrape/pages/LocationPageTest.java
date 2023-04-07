package com.cuc.app.scrape.pages;

import com.cuc.app.scrape.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class LocationPageTest {

    private WebDriver driver;
    private LocationPage page;

    @BeforeEach
    void setUp () {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://shop.aldi.us/store/aldi/storefront");

        page = new LocationPage(driver);
    }

    @AfterEach
    void tearDown () {
    }
}
