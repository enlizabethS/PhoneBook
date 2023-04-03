package com.ait.phonebook;

import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethodsIf;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;


public class AddContactTests extends  TestBase{
    //precondition: 1. User is logged out; 2. log in
    @BeforeMethod
    public void  ensurePrecondition(){
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        } else{
            //click on Login link
            click(By.xpath("//a[contains(.,'LOGIN')]"));
            type(By.cssSelector("[placeholder='Email']"), "elisaveta.stepura@mail.ru");
            type(By.cssSelector("[placeholder='Password']"), "Liza159357!");
            //click on login button
            click(By.xpath("//button[contains(.,'Login')]"));
        }
    }
    @Test
    public void addContactPositiveTest(){
        //click on  Add link
        click(By.cssSelector("a:nth-child(5)"));
        //fill add contact form
        type(By.cssSelector("input:nth-child(1)"),"Liza");
        type(By.cssSelector("input:nth-child(2)"),"Bobrova");
        type(By.cssSelector("input:nth-child(3)"),"45278492740");
        type(By.cssSelector("input:nth-child(4)"),"elisaveta@mail.ru");
        type(By.cssSelector("input:nth-child(5)"),"Moscow");
        type(By.cssSelector("input:nth-child(6)"),"creative");
        //click on save button
        click(By.cssSelector(".add_form__2rsm2 button"));
        //verify new contact is added
        Assert.assertTrue(isContactCreated("Liza"));
    }
    public boolean isContactCreated(String text) {
        List<WebElement> contacts = driver.findElements((By.cssSelector("h2")));

        for (WebElement el: contacts) {
            if (el.getText().contains(text))
                return true;
        }
        return false;
    }

}
