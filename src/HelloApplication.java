import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashSet;


public class HelloApplication extends Application {
    private final HashSet<String> keys = new HashSet<>();
    @Override
    public void start(Stage stage) throws IOException {
        int screenWidth = 1000;
        int screenHeight = 700;
        Warrior player1 = new Warrior("1");
        Archer player2 = new Archer("2");

        Pane p = new Pane(player1.getPlayer(), player2.getPlayer());
        Scene scene = new Scene(p,screenWidth,screenHeight);
        Movement.initialPlace(player1, player2, screenWidth, screenHeight, p);

        scene.setOnKeyPressed(e -> keys.add(e.getCode().toString()));
        scene.setOnKeyReleased(e -> keys.remove(e.getCode().toString()));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                Movement.move(keys);
            }
        }.start();


        stage.setScene(scene);
        stage.setTitle("Match");
        stage.show();

        p.requestFocus();


    }


    public static void main(String[] args) {
        launch();
    }

}


