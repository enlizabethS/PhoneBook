package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    //precondition: 1. Verify User is log out; 2. log in; 3. add contact
    @BeforeMethod
    public void ensurePrecondition(){
        if (!isElementPresent(By.xpath("//a[contains(.,'LOGIN')]"))) {
            click(By.xpath("//button[contains(.,'Sign Out')]"));
        } else{
            //click on Login link
            click(By.xpath("//a[contains(.,'LOGIN')]"));
            type(By.cssSelector("[placeholder='Email']"), "elisaveta.stepura@mail.ru");
            type(By.cssSelector("[placeholder='Password']"), "Liza159357!");
            //click on login button
            click(By.xpath("//button[contains(.,'Login')]"));
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
        }
    }
    @Test
    public void removeContactTest(){
        int sizeBefore = sizeOfContacts();
        //click on Card
        click(By.cssSelector(".contact-item_card__2SOIM"));
        //click on remove button
        click(By.xpath("//button[contains(.,'Remove')]"));
        pause(1000);
        int sizeAfter = sizeOfContacts();
        //verify contact is removed
      Assert.assertEquals(sizeBefore-sizeAfter,1);

    }
    public void pause(int millis)  {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public int sizeOfContacts(){
        if(driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size()>0){
            return driver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        } else {
            return 0;
        }
    }

}
