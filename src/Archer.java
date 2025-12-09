import javafx.scene.control.Button;

public class Archer extends Character{
    private Button player;
    public Archer(String characterName) {
        super(characterName, "Human", "Archer", new Weapon("w1", 100, 10, 250), 120, 80, 10, 5, 50, 1);
        player =  new Button("A");
    }

    public Button  getPlayer() {
        return player;
    }
}