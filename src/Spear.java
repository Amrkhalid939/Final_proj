
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Spear extends Weapon {
    public Spear() {
        super("spear", 300);


        setWeaponShape(new Rectangle(10,35));
        setWeaponcolor(Color.GOLD);
    }
}