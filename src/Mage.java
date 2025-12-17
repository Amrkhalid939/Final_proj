import javafx.scene.control.Button;

public class Mage extends Character{
    private Button player;
    public Mage(String characterName) {
        super(characterName,   new MagicBall(),new MagicStick(),
                120, 80, 4, 10);
        player =  new Button("M");
    }

    public Button  getPlayer() {
        return player;
    }
}