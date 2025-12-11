// Note the new imports
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

public class Projectile {
    private Shape shape;

    private int velocity;
    private long lastRefreshTime;
    private static final int REFRESH_THRESHOLD = 1;

    public Projectile(String playerName) {

        Rectangle rect = new Rectangle(20, 8);

        if (playerName.equals("1")) {
            this.velocity = 6;
            rect.setFill(Color.BLUE);
        } else {
            this.velocity = -6;
            rect.setFill(Color.RED);
        }
        this.shape = rect;
        this.lastRefreshTime = System.currentTimeMillis();
    }


    public Shape getShape() {
        return shape;
    }
    public void move() {
        long now = System.currentTimeMillis();
        if (now - lastRefreshTime >= REFRESH_THRESHOLD) {

            shape.setLayoutX(shape.getLayoutX() + velocity);
            lastRefreshTime = now;
        }
    }
}