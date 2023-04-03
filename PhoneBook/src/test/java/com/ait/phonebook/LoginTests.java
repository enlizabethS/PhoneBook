package com.ait.phonebook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }
    @Test
    public void loginRegisteredUserPositiveTest (){
        //click on Login link
        clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(isLoginRegFormPresent());
        //fill registration form
        fillLoginRegForm("elisaveta.stepura@mail.ru", "Liza159357!");
        //click on login button
        clickOnLoginButton1();
        //verify User logged in
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginRegisteredUserWithInvalidPasswordNegativeTest (){
        //click on Login link
        clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(isLoginRegFormPresent());
        //fill registration form
        fillLoginRegForm("elisaveta.stepura@mail.ru", "Liza159357");
        //click on login button
        clickOnLoginButton();
        //check alert is appeared
       Assert.assertTrue(isAlertPresent());
    }

}
