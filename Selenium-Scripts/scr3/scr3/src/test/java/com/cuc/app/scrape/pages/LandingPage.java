package com.cuc.app.scrape.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathFactoryConfigurationException;

// page_url = https://shop.aldi.us/
public class LandingPage {

    private final XPathString targetHowItWorksDiv = new XPathString("//div[@role='dialog'");

    @FindBy(css = ".section")
    public WebElement howItWorksDiv1;

    @FindBy(xpath = "//div[@role='dialog']")
    public WebElement howItWorksDiv2;

    @FindBy(xpath = "//span[normalize-space(text()) = 'x']")
    public WebElement closeIconSpan;

    @FindBy(xpath = "//div[contains(@class, 'bit')]")
    public WebElement versionDiv;

    @FindBy(xpath = "//*[@id='fb-root']")
    public WebElement fbRootDiv;

    @FindBy(xpath = "//div[@style='position: absolute; top: -10000px; width: 0px; height: 0px;']")
    public WebElement elementDiv;

    @FindBy(xpath = "//div[@style='position: absolute; top: -10000px; width: 0px; height: 0px;']//div")
    public WebElement elementDiv2;

    @FindBy(xpath = "/html/body/img[1]")
    public WebElement elementImg;

    @FindBy(xpath = "//img[contains(@src, 'uee')]")
    public WebElement elementImg2;

    @FindBy(xpath = "//img[contains(@src, 'uee')]")
    public WebElement elementImg3;

    @FindBy(xpath = "/html/body/img[3]")
    public WebElement elementImg4;

    @FindBy(xpath = "//img[contains(@src, 'allpages')]")
    public WebElement elementImg5;

    @FindBy(xpath = "//img[contains(@src, 'signstrt')]")
    public WebElement elementImg6;

    @FindBy(xpath = "/html/body/img[6]")
    public WebElement elementImg7;

    @FindBy(xpath = "//img[contains(@src, 'gzaxdyz')]")
    public WebElement elementImg8;

    @FindBy(xpath = "/html/body/img[8]")
    public WebElement elementImg9;

    @FindBy(xpath = "//*[@id='ssIFrame_google']")
    public WebElement ssiframeGoogleIframe;

    @FindBy(xpath = "//div[contains(@style, '0s')]")
    public WebElement elementDiv3;

    @FindBy(xpath = "//div[contains(@style, '0.5;')]")
    public WebElement elementDiv4;

    @FindBy(xpath = "//iframe[@scrolling='no']")
    public WebElement cVCgrzrscorIframe;
    

    // No page elements added

    public LandingPage(WebDriver driver) throws XPathFactoryConfigurationException {
        PageFactory.initElements(driver, this);
    }
}
