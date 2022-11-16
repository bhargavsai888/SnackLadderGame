package com.example.realsnakeladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class SnackLadder extends Application {
   public final int tileSize=40;
    int height=10;
    int width=10;
    int yline=430;
    int diceValue;
    Label randResult;
    boolean gameStart=true,turnOnePlayer=true,turnPlayerTwo=false;
    Group tileGroup=new Group();
   Random randresult=new Random();
   public Pane createContent(){
       Pane root=new Pane();
      root.setPrefSize(width*tileSize,height*tileSize+80);
       root.getChildren().addAll(tileGroup);


       for (int i = 0; i <height ; i++) {
           for (int j = 0; j <width ; j++) {
               Tile tile=new Tile(tileSize,tileSize);
               tile.setTranslateX(i*tileSize);
               tile.setTranslateY(j*tileSize);
               tileGroup.getChildren().addAll(tile);

           }
       }
       Player playerone=new Player(tileSize, Color.BLACK);
       Player playerTwo=new Player(tileSize-10, Color.WHITE);
       //add label
        randResult=new Label("Start the Game");
       randResult.setTranslateX(150);
       randResult.setTranslateY(yline-20);
       //add 3 buttons
       Button playerOneButton=new Button("Player One");
       playerOneButton.setTranslateX(20);
       playerOneButton.setTranslateY(yline);
       playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {


             if(gameStart==true) {
                 if (turnOnePlayer == true) {
                     getDiceValue();
                     playerone.movePlayer(diceValue);
                     playerone.playerAtSnakeOrLadder();
                     turnOnePlayer = false;
                   turnPlayerTwo = true;
                 }
             }
           }
       });


       Button startGame=new Button("Start Game");
       startGame.setTranslateX(160);
       startGame.setTranslateY(yline);

       Button playerTwoButton=new Button("Player Two");
       playerTwoButton.setTranslateX(300);
       playerTwoButton.setTranslateY(yline);
       playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
               if(gameStart==true) {
                   if (turnPlayerTwo == true) {
                       getDiceValue();
                       playerTwo.movePlayer(diceValue);
playerTwo.playerAtSnakeOrLadder();
                       turnOnePlayer = true;
                       turnPlayerTwo = false;
                   }
               }
           }
       });





       Image img=new Image("C:\\Users\\bharg\\IdeaProjects\\RealSnakeLadder\\src\\istockphoto-577332576-1024x1024.jpg");
       ImageView boardImage=new ImageView();
       boardImage.setImage(img);
       boardImage.setFitWidth(tileSize*width);
       boardImage.setFitHeight(tileSize*height);
       tileGroup.getChildren().addAll(boardImage,playerOneButton,startGame,playerTwoButton,randResult,playerone.getGamePiece(),playerTwo.getGamePiece()   );
       return root;
   }

private void getDiceValue(){
       diceValue=(int)(Math.random()*6+1);
       System.out.println(diceValue);
randResult.setText(Integer.toString(diceValue));
}
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake and Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}