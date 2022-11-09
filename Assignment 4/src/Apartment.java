import java.util.ArrayList;

public class Apartment {

    private ArrayList<Room> rooms;
    private Room entrance; // entrance own var, because every room adjacent to it


    public Apartment(){
        this.rooms = new ArrayList<>();
        this.entrance =  new Room("Hallway", false);
    }

    //TODO: Create logic for correct neighbor adding once a room is added
    public void extension(Room newRoom) {
        newRoom.addNeighbor(entrance);
        this.rooms.add(newRoom);
        this.entrance.addNeighbor(newRoom);
    }

    public void enter() {
        this.entrance.enter();
    }
}
