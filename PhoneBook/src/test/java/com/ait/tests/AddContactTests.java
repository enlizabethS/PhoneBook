package com.ait.tests;

import com.ait.tests.fw.DataProviderContact;
import com.ait.tests.model.Contact;
import com.ait.tests.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class AddContactTests extends  TestBase{
    //precondition: 1. User is logged out; 2. log in

    @BeforeMethod
    public void  ensurePrecondition(){
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        } else{
            //click on Login link
            app.getHeader().clickOnLoginLink();
            app.getUser().fillLoginRegForm(new User().setEmail("elisaveta.stepura@mail.ru")
                    .setPassword("Liza159357!"));
            //click on login button
            app.getUser().clickOnLoginButton1();
        }
    }
    @Test (enabled = false)
    public void addContactPositiveTest(){
        //click on  Add link
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
        //verify new contact is added
        Assert.assertTrue(app.getContact().isContactCreated("Liza"));
    }
    @Test (enabled = false,dataProvider = "addNewContact", dataProviderClass = DataProviderContact.class)
    public void addContactPositiveFromDataProviderTest(String name, String surname, String phone, String email, String address, String desc){
        //click on  Add link
        app.getHeader().clickOnAddLink();
        //fill add contact form
        app.getContact().addContact(new Contact().setName(name)
                .setSurName(surname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDesc(desc));
        //click on save button
        app.getContact().clickOnSaveButton();
        //verify new contact is added
        app.getContact().removeContact();
    }

    @Test (enabled = false,dataProvider = "addNewContactCSV", dataProviderClass = DataProviderContact.class)
    public void addContactPositiveFromDataProviderTestCSV(Contact contact){
        app.getHeader().clickOnAddLink();
        //fill add contact form
        app.getContact().addContact(contact);
        //click on save button
        app.getContact().clickOnSaveButton();
        //verify new contact is added
        app.getContact().removeContact();
    }

}
