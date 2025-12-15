import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class Axe extends Weapon {
    public Axe() {
        super("axe", 200, 8, 400,10);
        setWeaponShape(new Rectangle(15,30));
        setWeaponcolor(Color.DARKGRAY);

    }
}
