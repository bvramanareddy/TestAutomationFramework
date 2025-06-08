package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtility {

    private Logger logger = LoggerUtility.getLogger(this.getClass());
    private WebDriverWait wait;


    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver){
        super();
        this.driver.set(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
    }

    public BrowserUtility(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            driver.set(new ChromeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

        } else if (browserName.equalsIgnoreCase("edge")) {
            driver.set(new EdgeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        }
        else {
            System.out.println("Invalid Browser Selection- Please enter Chrome or Edge");
        }
    }

    public BrowserUtility(Browser browserName){
        if (browserName==Browser.CHROME){
            driver.set(new ChromeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        } else if (browserName==Browser.EDGE) {
            driver.set(new EdgeDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        }
        else if (browserName==Browser.FIREFOX) {
            driver.set(new FirefoxDriver());
            wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
        }
            else {
            System.out.println("Invalid Browser Selection- Please enter Chrome or Edge");
        }
    }

    public BrowserUtility(Browser browserName, boolean isHeadLess){
        if (browserName==Browser.CHROME){
            if (isHeadLess) {
                logger.info("Launching " + browserName + " with headless mode as " + isHeadLess);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver.set(new ChromeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
            else {
                driver.set(new ChromeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        } else if (browserName==Browser.EDGE) {
            if (isHeadLess) {
                logger.info("Launching " + browserName + " with headless mode as " + isHeadLess);
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                driver.set(new EdgeDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
            else {
                driver.set(new EdgeDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        }
        else if (browserName==Browser.FIREFOX) {
            if (isHeadLess) {
                logger.info("Launching " + browserName + " with headless mode as " + isHeadLess);
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver.set(new FirefoxDriver(options));
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
            else {
                driver.set(new FirefoxDriver());
                wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        }
        else {
            System.out.println("Invalid Browser Selection- Please enter Chrome or Edge");
        }
    }

    public void goToWebsite(String url){
        driver.get().get(url);
    }
    public void maximizeWindow(){
        driver.get().manage().window().maximize();
    }
    public void clickOn(By locator){
      //  WebElement element=  driver.get().findElement(locator); //Since we started using wait no need of findElement
        WebElement element=  wait.until(ExpectedConditions.elementToBeClickable(locator));
        logger.info("Element found and performing click now");
        element.click();
    }

    public void clickOnCheckBox(By locator){
        //  WebElement element=  driver.get().findElement(locator); //Since we started using wait no need of findElement
        WebElement element=  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("CheckBox found and clicking on it");
        element.click();
    }
    public void clickOn(WebElement  element){
        element.click();
    }
    public void enterText(By locator, String textToEnter){
        logger.info("finding element with locator " + locator);
       // WebElement element = driver.get().findElement(locator);
        WebElement element=  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Element found and now performing Text entering");
        element.sendKeys(textToEnter);
    }

    public void enterSpecialKey(By locator, Keys keyToEnter) {
        logger.info("finding element with locator " + locator);
      //  WebElement element = driver.get().findElement(locator);
        WebElement element=  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        logger.info("Element found and now performing Text entering");
        logger.info("Element found and now enter special key" + keyToEnter);
        element.sendKeys(keyToEnter);
    }
    public String getVisibleText(By locator){
       // WebElement element =  driver.get().findElement(locator);
        WebElement element=  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    public String getVisibleText(WebElement element){
        logger.info("Returning the visible text ");
        return element.getText();
    }

    public List<String> getAllVisibleText(By locator){
        List<WebElement> elementsList =  driver.get().findElements(locator);
        logger.info("Printing all product names as a list ");

        List<String> productVisibleTextList = new ArrayList<>();
        for (WebElement element: elementsList){
            productVisibleTextList.add(getVisibleText(element));
        }

        return productVisibleTextList;
    }

    public List<WebElement> getAllElements(By locator){
        List<WebElement> elementsList =  driver.get().findElements(locator);
        logger.info("Printing all product names as a list ");
        return elementsList;
    }

    public void selectFromDropDown(By dropDownLocator, String optionToSelect){
        logger.info("locating the dropdown element with locator " + dropDownLocator);
        WebElement element =driver.get().findElement(dropDownLocator);
        Select select = new Select(element);
        logger.info("Selecting the option with value "+ optionToSelect);
        select.selectByVisibleText(optionToSelect);
    }

    public void clearText(By textBoxLocator){
        WebElement element = driver.get().findElement(textBoxLocator);
        logger.info("Clearing the Text from the textbox filed");
        element.clear();
    }

    public String takeScreenshot(String fileName){
      TakesScreenshot screenshot =  (TakesScreenshot)driver.get();
        File screenShotData =  screenshot.getScreenshotAs(OutputType.FILE);
        Date date=  new Date();
        SimpleDateFormat format =  new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);

        String path = "./Screenshots/"+ fileName+" - "+timeStamp+".png";
        File screenShotFile = new File(path);
        try {
            FileUtils.copyFile(screenShotData, screenShotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

    public void quitBrowser(){
        driver.get().quit();
    }
}
