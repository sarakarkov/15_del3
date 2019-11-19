package Model;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

public class Player {
    private int id;
    private String name;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Player() {

    }

    public String getName(){
        return this.name;
    }
    public int getId(){ return this.id; }

}
