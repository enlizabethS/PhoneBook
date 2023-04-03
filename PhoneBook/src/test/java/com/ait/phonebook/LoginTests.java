package com.ait.phonebook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }
    @Test
    public void loginRegisteredUserPositiveTest (){
        //click on Login link
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        //verify Registration form is displayed
        Assert.assertTrue(isElementPresent(By.className("login_login__3EHKB")));
        //fill registration form
        type(By.cssSelector("[placeholder='Email']"), "elisaveta.stepura@mail.ru");
        type(By.cssSelector("[placeholder='Password']"), "Liza159357!");
        //click on login button
        click(By.xpath("//button[contains(.,'Login')]"));
        //verify User logged in
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }@Test
    public void loginRegisteredUserWithInvalidPasswordNegativeTest (){
        //click on Login link
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        //verify Registration form is displayed
        Assert.assertTrue(isElementPresent(By.className("login_login__3EHKB")));
        //fill registration form
        type(By.cssSelector("[placeholder='Email']"), "elisaveta.stepura@mail.ru");
        type(By.cssSelector("[placeholder='Password']"), "Liza159357");
        //click on login button
        click(By.xpath("//button[contains(.,'Login')]"));
        //check alert is appeared
       Assert.assertTrue(isAlertPresent());
    }
    public boolean isAlertPresent(){
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
        if (alert == null){
            return false;
        }else {
            driver.switchTo().alert();
            alert.accept();
            return true;
        }
    }
}
