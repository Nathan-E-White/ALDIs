package com.cuc.app.scrape.pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

class LandingPageTest {

    private WebDriver driver;
    private LandingPage page;

    @BeforeEach
    void setUp () {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get("https://shop.aldi.us/");

        this.page = new LandingPage(driver);
    }

    @AfterEach
    void tearDown () {
    }
}
