import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashSet;

public class HelloApplication extends Application {

    private final HashSet<String> keys = new HashSet<>();
    private static final int SCREEN_WIDTH = 1000;
    private static final int SCREEN_HEIGHT = 700;


    public void start(Stage stage) throws IOException {

        Label p1Label = new Label("Player 1 :");
        ComboBox<String> p1Select = new ComboBox<>();
        p1Select.getItems().addAll("Warrior", "Mage", "Archer");
        p1Select.setValue("Warrior");

        VBox p1Box = new VBox(10, p1Label, p1Select);
        p1Box.setAlignment(Pos.CENTER);


        Label p2Label = new Label("Player 2 :");
        ComboBox<String> p2Select = new ComboBox<>();
        p2Select.getItems().addAll("Warrior", "Mage", "Archer");
        p2Select.setValue("Archer");

        VBox p2Box = new VBox(10, p2Label, p2Select);
        p2Box.setAlignment(Pos.CENTER);


        HBox selectionContainer = new HBox(50, p1Box, p2Box);
        selectionContainer.setAlignment(Pos.CENTER);


        Button startButton = new Button("START GAME");
        startButton.setStyle("-fx-font-size: 15px; -fx-padding: 10 20 10 20;");


        VBox root = new VBox(50, selectionContainer, startButton);
        root.setAlignment(Pos.CENTER);


        Scene selectionScene = new Scene(root, 600, 400);

        stage.setScene(selectionScene);
        stage.setTitle("Character Selection");
        stage.show();


        startButton.setOnAction(e -> {
            String p1Choice = p1Select.getValue();
            String p2Choice = p2Select.getValue();
            launchGame(stage, p1Choice, p2Choice);
        });
    }


    private void launchGame(Stage stage, String p1Type, String p2Type) {


        Character player1 = createCharacter(p1Type, "1");
        Character player2 = createCharacter(p2Type, "2");
        Pane p = new Pane(player1.getPlayer(), player2.getPlayer());
        Scene gameScene = new Scene(p, SCREEN_WIDTH, SCREEN_HEIGHT);


        Movement.initialPlace(player1, player2, SCREEN_WIDTH, SCREEN_HEIGHT, p);
        gameScene.setOnKeyPressed(e -> keys.add(e.getCode().toString()));
        gameScene.setOnKeyReleased(e -> keys.remove(e.getCode().toString()));


        new AnimationTimer() {
            @Override
            public void handle(long now) {
                Movement.move(keys);
            }
        }.start();

        stage.setScene(gameScene);
        stage.setFullScreen(false);
        stage.setTitle("Match: " + p1Type + " vs " + p2Type);

        p.requestFocus();
    }


    private Character createCharacter(String type, String name) {
        switch (type) {
            case "Warrior":
                return new Warrior(name);
            case "Mage":
                return new Mage(name);
            case "Archer":
                return new Archer(name);
            default:
                return new Warrior(name);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
