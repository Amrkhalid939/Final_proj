import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MagicStick extends Weapon {
    public MagicStick() {
        super("magicStick", 200);

        setWeaponShape(new Rectangle(10,30));
        setWeaponcolor(Color.PURPLE);
    }
}
