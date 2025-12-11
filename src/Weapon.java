public class Weapon {
    private String name;
    private double range;
    private double speed;
    private int cooldown;
    private long lastFireTime;

    public Weapon(String name, double range, double speed, int cooldown) {
        this.name = name;
        this.range = range;
        this.speed = speed;
        this.cooldown = cooldown;
        this.lastFireTime = System.currentTimeMillis();
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