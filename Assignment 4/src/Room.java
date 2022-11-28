import java.util.ArrayList;
import java.util.Scanner;
/**
 * Gruppe H7
 * Jasper Angl (108021103663)
 * Philipp Lehmann (108021228860)
 * Malte Janek Kottmann (108021220217)
 */

public class Room {
    private final String name;
    private boolean lightning;
    private final ArrayList<Room> neighbors;
    public Room(String name, boolean lightning) {
        this.name = name;
        this.lightning = lightning;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Room room) {
        if (!isNeighbor(room)) {
            this.neighbors.add(room);
            room.neighbors.add(this);
        }
    }

    public boolean lightOn() {
        return this.lightning;
    }

    public String getName() {
        return this.name;
    }

    protected void switchLight() {
        this.lightning = !this.lightning;
        if (this.lightning) {
            System.out.println("Light has been turned on");
        } else {
            System.out.println("Light has been turned off");
        }
    }

    /**
     * Here we ask the Questions, say which room we're in etc.
     */
    protected void enter() {
        System.out.println("You're in the " + this.name);
        System.out.println("What do you want to do?");
        System.out.println("1) Switch Light setting");
        System.out.println("2) Enter neighbor room");
        System.out.println("3) Leave room");
        int reply = this.receiveReply(3);
        if (reply == 1) {
            this.switchLight();
            this.enter();
        }
        if (reply == 2) {
            this.enterNeighborRoom();
            // Here below we utilize the call-stack. We stack the enter() method of a new room on-top of the current one.
            // This way we always return to the previously entered room, once it finished processing the enter() method
            // of the new room.
            this.enter();
        }
        if (reply == 3) {
            System.out.println("Leaving the " + this.name);
        }
    }


    protected int receiveReply(int range) {
        // Scanner can purposefully wait till nextInt and therefore needs less error handling, in contrast to BufferReader
        Scanner reader = new Scanner(System.in);
        int answer = reader.nextInt();
        if (answer > 0 && answer <= range) {
            return answer;
        } else {
            throw new IllegalArgumentException("Wrong integer input");
        }
    }

    protected void enterNeighborRoom() {
        System.out.println("Which room do you want to enter?");
        for(int i=1; i<=this.neighbors.size(); i++) {
            Room currRoom = this.neighbors.get(i-1);
            System.out.println(i + ") " + currRoom.name);
        }
        int answer = this.receiveReply(this.neighbors.size());
        this.neighbors.get(answer-1).enter();
    }

    private boolean isNeighbor(Room room) {
        for(int i=0; i<room.neighbors.size();i++) {
            if (this == room.neighbors.get(i)) {
                return true;
            }
        }
        return false;
    }



}
