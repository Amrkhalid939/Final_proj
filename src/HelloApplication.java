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
        p1Label.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        ComboBox<String> p1Select = new ComboBox<>();
        p1Select.getItems().addAll("Warrior", "Mage", "Archer");
        p1Select.setValue("Choose Character");

        VBox p1Box = new VBox(10, p1Label, p1Select);
        p1Box.setAlignment(Pos.CENTER);

        Label p2Label = new Label("Player 2 :");
        p2Label.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        ComboBox<String> p2Select = new ComboBox<>();
        p2Select.getItems().addAll("Warrior", "Mage", "Archer");
        p2Select.setValue("Choose Character");

        VBox p2Box = new VBox(10, p2Label, p2Select);
        p2Box.setAlignment(Pos.CENTER);

        HBox selectionContainer = new HBox(50, p1Box, p2Box);
        selectionContainer.setAlignment(Pos.CENTER);

        Button startButton = new Button("START MATCH");
        startButton.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-size: 20px; -fx-padding: 10 30; -fx-font-weight: bold; -fx-cursor: hand;");

        VBox root = new VBox(50, selectionContainer, startButton);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #2c3e50;");

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
        styleCharacter(player1, p1Type);
        styleCharacter(player2, p2Type);

        Pane p = new Pane(player1.getPlayer(), player2.getPlayer());
        p.setStyle("-fx-background-color: #34495e;");

        Scene gameScene = new Scene(p, SCREEN_WIDTH, SCREEN_HEIGHT);

        Movement.initialPlace(player1, player2, SCREEN_WIDTH, SCREEN_HEIGHT, p);

        gameScene.setOnKeyPressed(e -> keys.add(e.getCode().toString()));
        gameScene.setOnKeyReleased(e -> keys.remove(e.getCode().toString()));

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                Movement.move(keys);
                checkGameOver(stage, player1, player2, this);
            }
        };
        gameLoop.start();

        stage.setScene(gameScene);
        stage.setFullScreen(false);
        stage.setTitle("Match: " + p1Type + " vs " + p2Type);
        p.requestFocus();
    }

    private void checkGameOver(Stage stage, Character p1, Character p2, AnimationTimer timer) {
        if (p1.getHealth() <= 0) {
            timer.stop();
            showEndScreen(stage, "Player 1", "Player 2");
        } else if (p2.getHealth() <= 0) {
            timer.stop();
            showEndScreen(stage, "Player 2", "Player 1");
        }
    }

    private void showEndScreen(Stage stage, String loser, String winner) {
        Label loseLabel = new Label(loser + " HAS FALLEN!");
        loseLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: #e74c3c; -fx-font-weight: bold;");

        Label winLabel = new Label("VICTORY FOR " + winner.toUpperCase() + "!");
        winLabel.setStyle("-fx-font-size: 36px; -fx-text-fill: #2ecc71; -fx-font-weight: bold;");

        Button exitButton = new Button("EXIT GAME");
        exitButton.setStyle("-fx-background-color: #c0392b; -fx-text-fill: white; -fx-font-size: 18px; -fx-padding: 10 30; -fx-font-weight: bold;");
        exitButton.setOnAction(e -> System.exit(0));

        VBox endLayout = new VBox(20, loseLabel, winLabel, exitButton);
        endLayout.setAlignment(Pos.CENTER);
        endLayout.setStyle("-fx-background-color: #2c3e50;");

        Scene endScene = new Scene(endLayout, 600, 400);
        stage.setScene(endScene);
    }

    private void styleCharacter(Character c, String type) {
        Button b = c.getPlayer();
        String baseStyle = "-fx-text-fill: white; -fx-font-weight: bold; -fx-border-color: black; -fx-border-width: 2px;";
        switch (type) {
            case "Warrior": b.setStyle(baseStyle + "-fx-background-color: #c0392b;"); break;
            case "Mage":    b.setStyle(baseStyle + "-fx-background-color: #8e44ad;"); break;
            case "Archer":  b.setStyle(baseStyle + "-fx-background-color: #27ae60;"); break;
            default:        b.setStyle(baseStyle + "-fx-background-color: grey;");
        }
    }

    private Character createCharacter(String type, String name) {
        switch (type) {
            case "Warrior": return new Warrior(name);
            case "Mage": return new Mage(name);
            case "Archer": return new Archer(name);
            default: return new Warrior(name);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
