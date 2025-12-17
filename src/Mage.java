import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Mage extends Character{
    private ImageView player;
    public Mage(String characterName) {
        super(characterName,   new MagicBall(),new MagicStick(),
                120, 80, 4, 10);
        player =  new ImageView(new Image("/Images/Mage.png"));
    }

    public ImageView getPlayer() {
        return player;
    }
}