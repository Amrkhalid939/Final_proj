import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MagicBall extends Weapon{
    public MagicBall(){
        super("MagicBall",450);
        setWeaponShape(new Rectangle(25,25));
        setWeaponcolor(Color.PURPLE);
    }
}