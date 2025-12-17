import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sword extends Weapon{
    public Sword(){
        super("sword", 250);
        setWeaponShape(new Rectangle(5,30));
        setWeaponcolor(Color.SILVER);
    }

}


