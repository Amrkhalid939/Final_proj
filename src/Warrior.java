import javafx.scene.control.Button;

public class Warrior extends Character{
    private Button player;
    public Warrior(String characterName) {
        super(characterName, "Human", "Warrior", new Sword(),new Axe(),
                20, 120, 10, 3, 100, 1);
        player =  new Button("W");
    }

//    public void puff(Weapon){
//        if (Weapon=="Sword"){
//            Armor+=50;
//            damage+=5;
//
//        }
//
//        else if (Weapon=="Bow"||Weapon=="Magic Stick"){
//            Armor-=30;
//            damage-=3;
//            speed-=1;
//        }
//
//        else return;
//    }1

    public Button  getPlayer() {
        return player;
    }

    public void setSecondweapon(){

    }

}
