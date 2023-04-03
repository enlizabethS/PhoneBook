package com.ait.phonebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.NoSuchElementException;

public class TestBase {

        WebDriver driver;

        @BeforeSuite
        public void setUp() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.get("https://telranedu.web.app");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        public boolean isElementPresent(By locator) {
            return driver.findElements(locator).size()>0;
        }

        public boolean isElementPresent2(By by) {
            try {
                driver.findElement(by);
                return true;
            } catch (NoSuchElementException ex) {
                return false;
            }
        }

        @AfterMethod(enabled = false)
        public void tearDown() {
            driver.quit();
        }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }
}
