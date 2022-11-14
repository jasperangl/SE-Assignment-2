import java.util.ArrayList;
/**
 * Gruppe H7
 * Jasper Angl (108021103663)
 * Philipp Lehmann (108021228860)
 * Malte Janek Kottmann (108021220217)
 */
public class Apartment {

    private ArrayList<Room> rooms;
    private Room entrance; // entrance own variable, because every room adjacent to it


    public Apartment(){
        this.rooms = new ArrayList<>();
        this.entrance =  new Room("Hallway", false);
        this.rooms.add(this.entrance);
    }

    public void addNewRoom(Room newRoom) {
        this.rooms.add(newRoom);
        this.entrance.addNeighbor(newRoom);
    }

    public void enter() {
        this.entrance.enter();
        this.checkApartmentState();
    }

    private void checkApartmentState(){
        for (Room currRoom : rooms) {
            if (currRoom.lightOn()) {
                System.out.println("Warning: Light in the " + currRoom.getName() + " is still on");
            }
            if (currRoom instanceof Bathroom) {
                if (((Bathroom) currRoom).showerOn()) {
                    System.out.println("Warning: Shower in the " + currRoom.getName() + " is still on");
                }
            }
            if (currRoom instanceof Kitchen) {
                if (((Kitchen) currRoom).stoveOn()) {
                    System.out.println("Warning: Stove in the " + currRoom.getName() + " is still on");
                }
            }
        }
        System.out.println("Leaving Apartment now");
    }
}
