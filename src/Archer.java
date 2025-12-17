import javafx.scene.control.Button;

public class Archer extends Character{
    private Button player;
    public Archer(String characterName) {
        super(characterName,   new Bow(), new Spear(),
                20,100, 5, 12);
        player =  new Button("A");
    }


    public Button  getPlayer() {
        return player;
    }
}