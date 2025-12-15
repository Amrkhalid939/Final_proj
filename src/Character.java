import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Character {
    private String name;
    private String race;
    private String type;
    private Weapon weapon1;
    private Weapon weapon2;
    private Weapon active;
    private double range;
    private double health;
    private double damage;
    private double speed;




    public Character(String name, String race, String type, Weapon weapon1, Weapon weapon2,
                     double range,  double health, double damage, double speed, double armor, int level) {
        this.name = name;
        this.race = race;
        this.type = type;
        this.weapon1 = weapon1;
        this.weapon2 = weapon2;
        this.active=weapon1;
        this.range = range;
        this.health = health;
        this.damage = damage;
        this.speed = speed;


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
        return weapon1;
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

    public void setHealth(double health) {
        this.health = health;
    }

    public Button getPlayer() {
        return new Button("X");
    }

    public Projectile fire() {
        return active.fire(this.name,this.type);
    }

    public Weapon getActive() {
        return active;
    }

    public void switchWeapon(){
        if (active==weapon1)
            active=weapon2;


        else active=weapon1;

    }


}
