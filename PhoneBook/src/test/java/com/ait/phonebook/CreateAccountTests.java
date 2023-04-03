package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        //click on Login link
        clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(isLoginRegFormPresent());
        //fill registration form
        fillLoginRegForm("elisaveta.stepura@mail.ru", "Liza159357!");
        //click on Registration button
        clickOnLoginButton();
        //verify Log out button is displayed
        Assert.assertTrue(isSignOutButtonPresent());
    }

}
