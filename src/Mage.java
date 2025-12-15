import javafx.scene.control.Button;

public class Mage extends Character{
    private Button player;
    public Mage(String characterName) {
        super(characterName, "Human", "Mage", new MagicBall(),new MagicStick(),
                120, 80, 20, 4, 50, 1);
        player =  new Button("M");
    }



//    public void puff(Weapon){
//        if (Weapon=="Magic Stick"){
//            Armor+=20;
//            damage+=5;
//
//        }
//
//        else if (Weapon=="Sword"||Weapon=="Bow"){
//            Armor-=15;
//            damage-=7;
//            speed-=1;
//        }
//
//        else return;
//    }






    public Button  getPlayer() {
        return player;
    }
}