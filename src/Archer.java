import javafx.scene.control.Button;

public class Archer extends Character{
    private Button player;
    public Archer(String characterName) {
        super(characterName, "Human", "Archer", new Weapon("w1", 100, 10, 250),
                120, 80, 10, 5, 50, 1);
        player =  new Button("A");
    }


    public void puff(Weapon){
        if (Weapon=="Bow"){
            Armor+=20;
            damage+=5;

        }

        else if (Weapon=="Sword"||Weapon=="Magic Stick"){
            Armor-=10;
            damage-=4;
            speed-=2;
        }

        else return;
    }




    public Button  getPlayer() {
        return player;
    }
}