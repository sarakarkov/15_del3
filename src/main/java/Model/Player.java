package Model;

import gui_fields.GUI_Car;
import gui_fields.GUI_Player;

public class Player {
    private int id;
    private String name;
    private int position = 0;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void setPosition(int position) { this.position = position; }

    public int getPosition() {return this.position;}
    public String getName(){
        return this.name;
    }
    public int getId(){ return this.id; }

}
