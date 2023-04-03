package com.ait.phonebook;

import com.ait.phonebook.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        //click on Login link
        click(By.xpath("//a[contains(.,'LOGIN')]"));
        //verify Registration form is displayed
        Assert.assertTrue(isElementPresent(By.className("login_login__3EHKB")));
        //fill registration form
        type(By.cssSelector("[placeholder='Email']"), "elisaveta.stepura@mail.ru");
        type(By.cssSelector("[placeholder='Password']"), "Liza159357!");
        //click on Registration button
        click(By.xpath("//button[contains(.,'Registration')]"));
        //verify Log out button is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[contains(.,'Sign Out')]")));
    }

}
