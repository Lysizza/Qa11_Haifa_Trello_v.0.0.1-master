package tests;

import models.Auth;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangeAvatarTest extends TestBase{

    @BeforeMethod
    public void preCondition(){
        app.user().initLogin();
        app.user().fillLoginForm(Auth.builder().email("alisa.test25@gmail.com").password("As7166735@$").build());
        app.user().submitLogin();
    }
@Test
    public void changeAvaterTest(){
        app.user().clickAvatarImg();
        app.user().openProfileVisibility();
        app.user().navigateToAtlassianProfile();
        app.user().pause(3000);

    Assert.assertTrue(app.user().getURL().contains("https://id.atlassian.com/manage-profile"));

    app.user().initChangePhoto();
    app.user().uploadPhoto("D:\\Alisa AUTO\\projarchives\\Qa11_Haifa_Trello_v.0.0.1-master\\fox.jpg");

    Assert.assertTrue(app.user().isAvatarChanged());
    app.user().returnToTrelloFromAtlassian();

    Assert.assertTrue(app.user().getURL().contains("https://trello.com"));
    }
    @Test
    public void changeAvatarTest2(){
        app.user().clickAvatarImg();
        app.user().openProfileVisibility();
        app.user().navigateToAtlassianProfile();
        app.user().pause(3000);

        Assert.assertTrue(app.user().getURL().contains("https://id.atlassian.com/manage-profile"));

        app.user().initChangePhoto();
        app.user().uploadPhoto("D:\\Alisa AUTO\\projarchives\\Qa11_Haifa_Trello_v.0.0.1-master\\fox.jpg");
        Assert.assertTrue(app.user().isAvatarChanged());
        app.user().returnToTrelloFromAtlassian();

        Assert.assertTrue(app.user().getURL().contains("https://trello.com"));


    }
}
