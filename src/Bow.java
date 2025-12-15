import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bow extends Weapon{
    public Bow(){
        super("Bow", 800, 6, 400,10);
        setWeaponShape(new Rectangle(8,20));
        setWeaponcolor(Color.BROWN);


    }
}
