package com.ait.tests;

import com.ait.tests.model.Contact;
import com.ait.tests.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{
    //precondition: 1. Verify User is log out; 2. log in; 3. add contact
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else{
            //click on Login link
            app.getHeader().clickOnLoginLink();
            app.getUser().fillLoginRegForm(new User()
                    .setEmail("elisaveta.stepura@mail.ru")
                    .setPassword("Liza159357!"));
            //click on login button
            app.getUser().clickOnLoginButton();
            app.getHeader().clickOnAddLink();
            //fill add contact form
            app.getContact().addContact(new Contact().setName("Liza")
                    .setSurName("Bobrova")
                    .setPhone("45278492740")
                     .setEmail("elisaveta@mail.ru")
                    .setAddress("Moscow")
                    .setDesc("creative"));
            //click on save button
            app.getContact().clickOnSaveButton();
        }
    }
    @Test
    public void removeContactTest(){
        int sizeBefore = app.getContact().sizeOfContacts();
        //click on Card

        app.getContact().removeContact();
        app.getContact().pause(2000);
        int sizeAfter = app.getContact().sizeOfContacts();
        //verify contact is removed
      Assert.assertEquals(sizeBefore-sizeAfter,1);
    }

}
