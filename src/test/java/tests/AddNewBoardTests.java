package tests;

import models.Auth;
import models.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewBoardTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        //login
        app.user().initLogin();
        app.user().fillLoginForm(Auth.builder().email("alisa.test25@gmail.com").password("As7166735@$").build());
        app.user().submitLogin();
    }


    @Test
    public void addNewBoardSuccess(){
        Board board = Board.builder().title("B52").color("Blue").build();

        app.board().initCteationBoard();
        app.board().fillBoardCreationForm(board);
        app.board().pause(3000);
        app.board().submitCrationBoard();
        app.board().pause(2000);
        app.board().returnToHome();
        app.board().pause(2000);
        Assert.assertTrue(app.board().isBoardCreatedByTitle(board));

    }
}
