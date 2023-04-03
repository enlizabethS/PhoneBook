package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    //precondition: 1. Verify User is log out; 2. log in; 3. add contact
    @BeforeMethod
    public void ensurePrecondition(){
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        } else{
            //click on Login link
            clickOnLoginLink();
            fillLoginRegForm("elisaveta.stepura@mail.ru", "Liza159357!");
            //click on login button
            clickOnLoginButton1();
            clickOnAddLink();
            //fill add contact form
            addContact("Liza", "Bobrova", "45278492740", "elisaveta@mail.ru", "Moscow", "creative");
            //click on save button
            clickOnSaveButton();
        }
    }
    @Test
    public void removeContactTest(){
        int sizeBefore = sizeOfContacts();
        //click on Card
        removeContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        //verify contact is removed
      Assert.assertEquals(sizeBefore-sizeAfter,1);

    }

}
