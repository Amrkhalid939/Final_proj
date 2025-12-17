import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Axe extends Weapon {
    public Axe() {
        super("axe", 400);
        setWeaponShape(new Rectangle(15,30));
        setWeaponcolor(Color.DARKGRAY);

    }
}
