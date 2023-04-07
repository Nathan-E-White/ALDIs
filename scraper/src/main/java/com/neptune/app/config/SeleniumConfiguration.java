package com.neptune.app.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeleniumConfiguration {

    @Bean
    public ChromeDriver driver() {
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--headless");
        return new ChromeDriver(opts);
    }
}
