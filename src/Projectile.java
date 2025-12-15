import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.paint.Color;

public class Projectile {
    private Shape shape;
    private int xVelocity;
    private int yVelocity;
    private long lastRefreshTime;
    private static final int threshold = 1;
    private double distanceTraveled = 0;
    private double maxRange;

    public Projectile(String playerName, String troopType, int dirX, int dirY) {
        Rectangle rect;
        if (dirX == 0 && dirY != 0) {
            rect = new Rectangle(8, 20);
        } else {
            rect = new Rectangle(20, 8);
        }

        int speed = 6;
        this.xVelocity = dirX * speed;
        this.yVelocity = dirY * speed;

        if (playerName.equals("1")) {
            rect.setFill(Color.BLUE);
        } else {
            rect.setFill(Color.RED);
        }
        this.maxRange = determineRange(troopType);
        this.shape = rect;
        this.lastRefreshTime = System.currentTimeMillis();
    }

    private double determineRange(String troopType) {
        switch (troopType.toLowerCase()) {
            case "bow":
                return 800;
            case "magicball":
            case "magicstick":
                return 500;
            case "spear":
                return 300;
            case "sword":
            case "axe":
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
            shape.setLayoutX(shape.getLayoutX() + xVelocity);
            shape.setLayoutY(shape.getLayoutY() + yVelocity);
            distanceTraveled += Math.sqrt((xVelocity * xVelocity) + (yVelocity * yVelocity));
            lastRefreshTime = now;
        }
        else if (distanceTraveled >= maxRange) {
            shape.setVisible(false);
        }
    }
}