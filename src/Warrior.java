import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Warrior extends Character{
    private ImageView player;
    public Warrior(String characterName) {
        super(characterName,   new Sword(),new Axe(),
                20, 120, 3, 14);
        player =  new ImageView(new Image("/Images/Warrior.png"));
    }

    public ImageView getPlayer() {
        return player;
    }

}
