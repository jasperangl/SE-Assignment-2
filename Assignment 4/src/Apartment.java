import java.util.ArrayList;

public class Apartment {

    private ArrayList<Room> rooms;
    private Room entrance; // entrance own variable, because every room adjacent to it


    public Apartment(){
        this.rooms = new ArrayList<>();
        this.entrance =  new Room("Hallway");
        this.rooms.add(this.entrance);
    }

    //TODO: Create logic for correct neighbor adding once a room is added
    public void addNewRoom(Room newRoom) {
        this.rooms.add(newRoom);
        this.entrance.addNeighbor(newRoom);
    }

    public void enter() {
        this.entrance.enter();
    }
}
