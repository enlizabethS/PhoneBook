package com.ait.phonebook;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddContactTests extends  TestBase{
    //precondition: 1. User is logged out; 2. log in
    @BeforeMethod
    public void  ensurePrecondition(){
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        } else{
            //click on Login link
            clickOnLoginLink();
            fillLoginRegForm("elisaveta.stepura@mail.ru", "Liza159357!");
            //click on login button
            clickOnLoginButton1();
        }
    }
    @Test
    public void addContactPositiveTest(){
        //click on  Add link
        clickOnAddLink();
        //fill add contact form
        addContact("Liza", "Bobrova", "45278492740", "elisaveta@mail.ru", "Moscow", "creative");
        //click on save button
        clickOnSaveButton();
        //verify new contact is added
        Assert.assertTrue(isContactCreated("Liza"));
    }

}
