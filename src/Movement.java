import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashSet;

public class Movement {
    private static Character player1;
    private static Character player2;
    private static ArrayList<Projectile> fire = new ArrayList<>();
    private static double player1Width;
    private static double player1Height;
    private static double player2Width;
    private static double player2Height;
    private static int screenWidth;
    private static int screenHeight;
    private static Pane p;
    private static ProgressBar healthBar1;
    private static ProgressBar healthBar2;


    public static void initialPlace(Character player1, Character player2, int screenWidth, int screenHeight, Pane p) {
        Button p1 = player1.getPlayer();
        Button p2 = player2.getPlayer();
        p1.setPrefWidth(50); p1.setPrefHeight(50);
        p2.setPrefWidth(50); p2.setPrefHeight(50);
        Movement.player1 = player1;
        Movement.player2 = player2;
        Movement.player1Width = 50;
        Movement.player1Height = 50;
        Movement.player2Width = 50;
        Movement.player2Height = 50;
        Movement.screenWidth = screenWidth;
        Movement.screenHeight = screenHeight;
        Movement.p = p;

        p1.relocate(screenWidth/4.0 - player1Width/2.0 ,screenHeight/2.0 - player1Height/2.0);
        player2.getPlayer().relocate(3 * screenWidth/4.0 - player2Width/2.0 ,screenHeight/2.0 - player2Height/2.0);

        Movement.healthBar1 = new ProgressBar(player1.getHealth());
        Movement.healthBar2 = new ProgressBar(player2.getHealth());
        healthBar1.setPrefWidth(200);
        healthBar1.setStyle("-fx-accent: green;");
        healthBar2.setPrefWidth(200);
        healthBar2.relocate(screenWidth-200,0);
        healthBar2.setStyle("-fx-accent: green;");


        Movement.p.getChildren().add(healthBar1);
        Movement.p.getChildren().add(healthBar2);


    }

    public static void move(HashSet<String> keys) {
        Node p1 = player1.getPlayer();
        Node p2 = player2.getPlayer();
        double p1Step = player1.getSpeed();
        double p2Step = player2.getSpeed();


        if (keys.contains("W")) p1.setLayoutY((p1.getLayoutY() >= p1Step) ? p1.getLayoutY() - p1Step : 0);
        if (keys.contains("S"))
            p1.setLayoutY((p1.getLayoutY() <= screenHeight - player1Height) ? p1.getLayoutY() + p1Step : screenHeight - player1Height);
        if (keys.contains("A")) p1.setLayoutX((p1.getLayoutX() > p1Step) ? p1.getLayoutX() - p1Step : 0);
        if (keys.contains("D"))
            p1.setLayoutX((p1.getLayoutX() < screenWidth / 2.0 - player1Width) ? p1.getLayoutX() + p1Step : screenWidth / 2.0 - player1Width);


        if (keys.contains("UP")) p2.setLayoutY((p2.getLayoutY() >= p2Step) ? p2.getLayoutY() - p2Step : 0);
        if (keys.contains("DOWN"))
            p2.setLayoutY((p2.getLayoutY() <= screenHeight - player2Height) ? p2.getLayoutY() + p2Step : screenHeight - player2Height);
        if (keys.contains("LEFT"))
            p2.setLayoutX((p2.getLayoutX() > screenWidth / 2.0) ? p2.getLayoutX() - p2Step : screenWidth / 2.0);
        if (keys.contains("RIGHT"))
            p2.setLayoutX((p2.getLayoutX() < screenWidth - player2Width) ? p2.getLayoutX() + p2Step : screenWidth - player2Width);

        fireMove(keys, p);
        fireRemove(p);
    }

    public static void fireMove(HashSet<String> keys, Pane p) {
        if (keys.contains("F")) {
            Projectile fire1 = player1.fire();
            if (fire1 != null) {
                fire.add(fire1);
                fire1.getLabel().relocate(player1.getPlayer().getLayoutX() + player1Width, player1.getPlayer().getLayoutY() + player1Height/2.0 - 10);
                p.getChildren().add(fire1.getLabel());
            }
        }

        if (keys.contains("L")) {
            Projectile fire2 = player2.fire();
            if (fire2 != null) {
                fire.add(fire2);
                fire2.getLabel().relocate(player2.getPlayer().getLayoutX(), player2.getPlayer().getLayoutY()+ player2Height/2.0 - 10);
                p.getChildren().add(fire2.getLabel());
            }
        }


        for(Projectile projectile: fire)
            projectile.move();
    }

    public static void fireRemove(Pane p) {

        ArrayList<Projectile> toRemoveFire = new ArrayList<>();
        ArrayList<Label> toRemoveShape = new ArrayList<>();



        for(Projectile projectile: fire){
            double x = projectile.getLabel().getLayoutX();
            double y = projectile.getLabel().getLayoutY();

            if (x >= 0 && y <= screenWidth){
                if(projectile.getLabel().getText().equals("1") &&
                        x + 10 >= player2.getPlayer().getLayoutX() &&
                        x <= player2.getPlayer().getLayoutX() + player2Width &&
                        y + 10 >= player2.getPlayer().getLayoutY() &&
                        y <= player2.getPlayer().getLayoutY() + player2Height){

                    player2.setHealth(player2.getHealth() - 10);
                    toRemoveFire.add(projectile);
                    toRemoveShape.add(projectile.getLabel());

                    healthBar2.setPrefWidth(healthBar2.getPrefWidth()-20);
                }

                if(projectile.getLabel().getText().equals("2") &&
                        x - 10>= player1.getPlayer().getLayoutX() &&
                        x <= player1.getPlayer().getLayoutX() + player1Width &&
                        y + 10>= player1.getPlayer().getLayoutY() &&
                        y <= player1.getPlayer().getLayoutY() + player1Height){

                    player1.setHealth(player1.getHealth() - 10);
                    toRemoveFire.add(projectile);
                    toRemoveShape.add(projectile.getLabel());

                    healthBar1.setPrefWidth(healthBar1.getPrefWidth()-20);
                }

            }
            else{
                toRemoveFire.add(projectile);
                toRemoveShape.add(projectile.getLabel());
            }
        }

        fire.removeAll(toRemoveFire);
        p.getChildren().removeAll(toRemoveShape);
    }

}
