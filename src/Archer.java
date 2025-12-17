import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Archer extends Character{
    private ImageView player;
    public Archer(String characterName) {
        super(characterName,   new Bow(), new Spear(),
                20,100, 5, 12);
        player =  new ImageView(new Image("/Images/Archer.png"));
    }


    public ImageView getPlayer() {
        return player;
    }
}