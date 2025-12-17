import javafx.scene.control.Button;

public class Warrior extends Character{
    private Button player;
    public Warrior(String characterName) {
        super(characterName,   new Sword(),new Axe(),
                20, 120, 3, 14);
        player =  new Button("W");
    }

    public Button  getPlayer() {
        return player;
    }

}
