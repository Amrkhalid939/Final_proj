import javafx.scene.control.Button;

public class Mage extends Character{
    private Button player;
    public Mage(String characterName) {
        super(characterName, "Human", "Mage", new Weapon("w1", 100, 10, 250), 120, 80, 20, 4, 50, 1);
        player =  new Button("M");
    }

    public Button  getPlayer() {
        return player;
    }
}