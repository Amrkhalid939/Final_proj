import java.util.Calendar;

public class Weapon {
    private String name;
    private double range;
    private double speed;
    private int cooldown;
    private Calendar lastFire;

    public Weapon(String name, double range, double speed, int cooldown) {
        this.name = name;
        this.range = range;
        this.speed = speed;
        this.cooldown = cooldown;
        this.lastFire =  Calendar.getInstance();
    }

    public Projectile fire(String playerName) {

        Calendar now = Calendar.getInstance();
        long duration = now.getTimeInMillis() - lastFire.getTimeInMillis();
        if (duration>cooldown) {
            lastFire = now;
            Projectile p = new Projectile(playerName);
            return p;
        }
        else {
            return null;
        }

    }
}
