package com.neptune.app.service;

import lombok.AllArgsConstructor;
// import org.checkerframework.common.value.qual.IntRange;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

// import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

@Service
@AllArgsConstructor
public class ScrapingService {

    public ChromeDriver driver;

    // @PostConstruct
    // void postConstruct() {
    //     System.setProperty("webdriver.chrome.driver", "\"$(which chromedriver)\"");
    // }

    public String scrapePage() throws InterruptedException, IOException {
        URL url = new URL("https://shop.aldi.us/store/items/item_18742194361?v4_item_id=items_23648-2629265");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url.toString());
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        String csv = "HEADER ROW HERE\r";

        Thread.sleep(getRandomUniform(1, 1023)+ getRandomUniform());
        WebElement ePrice = driver.findElement(By.xpath(
                "xpath=//*[@id=\"item_details\"]/div[1]/div[2]/div[1]/div[2]/div/span"));

        WebElement eSize = driver.findElement(By.xpath(
                "xpath=//*[@id=\"item_details\"]/div[1]/div[2]/div[1]/div[1]/span"));

        WebElement eName = driver.findElement(By.xpath(
                "xpath=//*[@id=\"item_details\"]/div[1]/div[2]/div[1]/h2/span"
        ));

        csv += eName.getText() + ", " + ePrice.getText() + ", " + eSize.getText() + "\r";
        return csv;
    }

    // org.checkerframework ???

    private long getRandomUniform() {
        return getRandomUniform(0L, 1024L);
    }
    private long getRandomUniform(long infinum, long supremum) {
        long range = Math.abs(-1L * infinum + supremum);
        return infinum + Math.round((range * Math.random())/2.d);
    }
}
