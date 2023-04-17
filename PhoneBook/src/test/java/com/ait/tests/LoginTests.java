package com.ait.tests;

import com.ait.tests.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHeader().isLoginLinkPresent()) {
            app.getHeader().clickOnSignOutButton();
        }
    }
    @Test
    public void loginRegisteredUserPositiveTest (){
        //click on Login link
        app.getHeader().clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //fill registration form
        app.getUser().fillLoginRegForm(new User().setEmail("elisaveta.stepura@mail.ru").setPassword("Liza159357!"));
        //click on login button
        app.getUser().clickOnLoginButton1();
        //verify User logged in
        Assert.assertTrue(app.getHeader().isSignOutButtonPresent());
        logger.info("User logged in. Actual result: " + app.getHeader().isSignOutButtonPresent() + ". Expected result: true");
    }

    @Test
    public void loginRegisteredUserWithInvalidPasswordNegativeTest (){
        //click on Login link
        app.getHeader().clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //fill registration form
        app.getUser().fillLoginRegForm(new User().setEmail("elisaveta.stepura@mail.ru")
                .setPassword("Liza159357"));
        //click on login button
        app.getUser().clickOnLoginButton();
        //check alert is appeared
       Assert.assertTrue(app.getHeader().isAlertPresent());
    }
    @Test
    public void loginRegisteredUserWithOutPasswordNegativeTest (){
        //click on Login link
        app.getHeader().clickOnLoginLink();
        //verify Registration form is displayed
        Assert.assertTrue(app.getUser().isLoginRegFormPresent());
        //fill registration form
        app.getUser().fillLoginRegForm(new User().setEmail("elisaveta.stepura@mail.ru"));
        //click on login button
        app.getUser().clickOnLoginButton();
        //check alert is appeared
      // Assert.assertTrue(isAlertPresent());
    }

}
