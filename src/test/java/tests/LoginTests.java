package tests;

import models.Auth;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTests extends TestBase{

@BeforeMethod
public void preCondition(){
    if(app.user().isLogged()){
        app.user().logout();
    }
}

   // @Test
  //  public void loginSuccess() throws InterruptedException {
//
//
//        // open form
//        wd.findElement(By.cssSelector("[href='/login']")).click();
//
//        //fill form:
//        // email
//        WebElement email = wd.findElement(By.id("user"));
//        email.click();
//        email.clear();
//        email.sendKeys("hatum.testing@gmail.com");
//
//        // click enter with atlassian
//        wd.findElement(By.id("login")).click();
//       // pause 2sec = 2000msec
//        Thread.sleep(2000);
//        //password
//        WebElement password = wd.findElement(By.id("password"));
//        password.click();
//        password.clear();
//        password.sendKeys("Hatum21$");
//
//        // submit form
//        wd.findElement(By.cssSelector("#login-submit")).click();
//
//
//        //Assert ? isLoginSUCCESS?
//
//        Assert.assertTrue(wd.findElements(By.cssSelector("[aria-label='Open member menu']")).size()>0);
//        Assert.assertTrue(wd.findElement(By.cssSelector("[aria-label='Open member menu']")).isDisplayed());
  //  }

    @Test
    public void loginSuccessTestTesttestJS(){

        app.user().initLogin();
        app.user().fillLoginFormTestTestTestJS("alisa.test25@gmail.com","As7166735@$");
        app.user().submitLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }
    @Test
    public void loginSuccessTestTesttest(){

        app.user().initLogin();
        app.user().fillLoginFormTestTestsTests("alisa.test25@gmail.com","As7166735@$");
        app.user().submitLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }


    @Test
    public void loginSuccessNew(){

        app.user().initLogin();
        app.user().fillLoginForm("alisa.test25@gmail.com","As7166735@$");
        app.user().submitLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }

    @Test
    public void loginSuccessNewModel(){

        User user = new User().withEmail("alisa.test25@gmail.com").withPassword("As7166735@$");


        app.user().initLogin();
        app.user().fillLoginForm(user);
        app.user().submitLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }

    @Test
    public void loginSuccessNewModel2(){


        app.user().initLogin();
        app.user().fillLoginForm(new User().withEmail("alisa.test25@gmail.com").withPassword("As7166735@$"));
        app.user().submitLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }
    @Test
    public void loginSuccessNewModelLombok(){

        Auth auth = Auth.builder().email("alisa.test25@gmail.com").password("As7166735@$").build();

        app.user().initLogin();
        app.user().fillLoginForm(auth);
        app.user().submitLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }
@Test
    public void loginUnsuccessfulWithWrongEmail(){
    app.user().initLogin();
    app.user().fillLoginFormWrongEmail("alisa.test25gmail.com","As7166735@$");
    app.user().submitLoginWithError();
    app.user().pause(1000);


    Assert.assertEquals(app.user().textErrorMessage(),"There isn't an account for this username");

}

@Test
    public void loginUnsuccessfulWithWrongPassword(){

    app.user().initLogin();
    app.user().fillLoginForm("alisa.test25@gmail.com","As7166735");
    app.user().submitLogin();

    app.user().pause(1000);
    Assert.assertTrue(app.user().textErrorWrongPasswordDisplaed().contains("Incorrect email address and / or password"));
    // hatum.testing@gmail.com  // Hat

    //Incorrect email address and / or password. If you recently migrated your Trello account to an Atlassian account,
    // you will need to use your Atlassian account password. Alternatively, you can get help logging in.
}

}
