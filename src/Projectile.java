import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

public class Projectile {
    private Shape shape;
    private int velocity;
    private long lastRefreshTime;
    private static final int threshold = 1;
    private double distanceTraveled = 0;
    private double maxRange;

    public Projectile(String playerName, String troopType) {
        Rectangle rect = new Rectangle(20, 8);
        if (playerName.equals("1")) {
            this.velocity = 6;
            rect.setFill(Color.BLUE);
        } else {
            this.velocity = -6;
            rect.setFill(Color.RED);
        }
        this.maxRange = determineRange(troopType);
        this.shape = rect;
        this.lastRefreshTime = System.currentTimeMillis();
    }

    private double determineRange(String troopType) {
        switch (troopType.toLowerCase()) {
            case "archer":
                return 800;
            case "mage":
                return 500;
            case "knight":
            case "warrior":
                return 150;
            default:
                return 400;
        }
    }
    public Shape getShape() {
        return shape;
    }
    public boolean OutOfRange() {
        return distanceTraveled >= maxRange;
    }
    public void move() {
        long now = System.currentTimeMillis();

        if (distanceTraveled < maxRange && (now - lastRefreshTime >= threshold)) {
            shape.setLayoutX(shape.getLayoutX() + velocity);
            distanceTraveled += Math.abs(velocity);
            lastRefreshTime = now;
        }
        else if (distanceTraveled >= maxRange) {
            shape.setVisible(false);
        }
    }
}