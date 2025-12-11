import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Character {
    private String name;
    private String race;
    private String type;
    private Weapon weapon;
    private double range;
    private double health;
    private double damage;
    private double speed;
    private double armor;
    private int level;

    public Character(String name, String race, String type, Weapon weapon, double range,  double health, double damage, double speed, double armor, int level) {
        this.name = name;
        this.race = race;
        this.type = type;
        this.weapon = weapon;
        this.range = range;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.armor = armor;
        this.level = level;
    }
    public String getName() {
        return name;
    }
    public String getRace() {
        return race;
    }
    public String getType() {
        return type;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    public double getRange() {
        return range;
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
    public double getArmor() {
        return armor;
    }
    public int getLevel() {
        return level;
    }
    public void setHealth(double health) {
        this.health = health;
    }

    public Button getPlayer() {
        return new Button("X");
    }

    public Projectile fire() {
        return weapon.fire(this.name,this.type);
    }

}
