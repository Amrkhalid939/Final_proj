import javafx.scene.control.Label;

import java.util.Calendar;

public class Projectile {
    private String playerName;
    private Label l;
    private String direction;
    private int refreshSpeed = 1;
    private int speed = 6;
    private Calendar lastRefresh;

    public Projectile(String playerName) {
        this.playerName = playerName;
        l = new Label(playerName);
        if(playerName.equals("1")) this.direction = "left";
        else this.direction = "right";
        lastRefresh = Calendar.getInstance();
    }

    public Label getLabel() {
        return l;
    }
    public void move() {
        Calendar now = Calendar.getInstance();
        long duration = now.getTimeInMillis() - lastRefresh.getTimeInMillis();
        if (duration>=refreshSpeed) {
            lastRefresh = now;
            if (direction.equals("left")) l.setLayoutX(l.getLayoutX() + speed);
            if (direction.equals("right")) l.setLayoutX(l.getLayoutX() - speed);
        }
    }
}
