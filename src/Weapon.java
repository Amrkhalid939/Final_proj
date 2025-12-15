import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Weapon  {
    private String name;
    private double range;
    private double speed;
    private int cooldown;
    private long lastFireTime;
    private Rectangle WeaponShape;


    public Weapon(String name, double range, double speed, int cooldown) {
        this.name = name;
        this.range = range;
        this.speed = speed;
        this.cooldown = cooldown;
        this.lastFireTime = System.currentTimeMillis();
    }
    public Rectangle getWeaponShape(){
        return WeaponShape;
    }
    public void UpdatePosition(double playerx,double playery){

        WeaponShape.setLayoutX (playerx+30);
        WeaponShape.setLayoutY(playery+10);
    }
    public void setWeaponShape(Rectangle R){
        this.WeaponShape=R;
    }
    public void setWeaponcolor(Color color){
        if (WeaponShape != null){
            WeaponShape.setFill(color);
        }

    }


    public Projectile fire(String playerName, String troopType) {
        long now = System.currentTimeMillis();

        if (now - lastFireTime >= cooldown) {
            lastFireTime = now;
            return new Projectile(playerName, troopType);
        }
        else {
            return null;
        }
    }
}