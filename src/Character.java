import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Character {
    private String name;
    private Weapon weapon1;
    private Weapon weapon2;
    private Weapon active;
    private double range;
    private double health;
    private double damage;
    private double speed;
    private int lastDirX;
    private int lastDirY;

    public Character(String name, Weapon weapon1, Weapon weapon2,
                     double range,  double health, double speed, double damage) {
        this.name = name;
        this.weapon1 = weapon1;
        this.weapon2 = weapon2;
        this.active=weapon1;
        this.range = range;
        this.health = health;
        this.speed = speed;
        this.damage = damage;

        if (name.equals("1")) {
            this.lastDirX = 1;
            this.lastDirY = 0;
        } else {
            this.lastDirX = -1;
            this.lastDirY = 0;
        }
    }
    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon1;
    }
    public double getHealth() {
        return health;
    }
    public double getDamage() {
        return damage;
    }

    public double getSpeed() {
        return speed;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public ImageView getPlayer() {
        return new ImageView(new Image("/Images/Warrior.png"));
    }

    public void setDirection(int x, int y) {
        if (x==0&&y==0)
            return;
        this.lastDirX = x;
        this.lastDirY = y;
    }

    public Projectile fire() {
        return active.fire(this.name, active.getName(), lastDirX, lastDirY);
    }
    public String getActiveString() {
        return getActive().toString();
    }

    public Weapon getActive() {
        return active;
    }

    public void switchWeapon(){
        if (active==weapon1)
            active=weapon2;
        else active=weapon1;
    }

    public int getLastDirX() {
        return lastDirX;
    }

    public int getLastDirY() {
        return lastDirY;
    }
}





