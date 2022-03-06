package tests;

import models.Auth;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoard extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.user().isLogginButtonPresent()) {
            app.user().initLogin();
            app.user().fillLoginForm(Auth.builder().email("alisa.test25@gmail.com").password("As7166735@$").build());
            app.user().submitLogin();
        }
    }

    @Test
    public void deleteOneBoard(){

    }
}