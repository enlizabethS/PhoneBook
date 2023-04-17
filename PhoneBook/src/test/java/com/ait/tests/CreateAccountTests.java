package com.ait.tests;

import com.ait.tests.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest() {
        //click on Login link
        app.getHeader().clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //fill registration form
        app.getUser().fillLoginRegForm(new User().setEmail("elisaveta.stepura@mail.ru")
                .setPassword("Liza159357!"));
        //click on Registration button
        app.getUser().clickOnLoginButton();
        //verify Log out button is displayed
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }

}
