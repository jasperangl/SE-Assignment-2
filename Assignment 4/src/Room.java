import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    private String name;
    private boolean lightning;
    private ArrayList<Room> neighbors;
    public Room(String name) {
        this.name = name;
        this.lightning = false;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Room room) {
        System.out.println(this.neighbors);
        if (!isNeighbor(room)) {
            this.neighbors.add(room);
            room.neighbors.add(this);
        }
    }

    public ArrayList<Room> getNeighbors() {
        return this.neighbors;
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
     * Here we ask the Questions, say which room were in etc.
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
            this.enter(); // This will ensure you will always come back to the previous room upon leaving
        }
        if (reply == 3) {
            System.out.println("Leaving the " + this.name);
        } else {
            throw new IllegalArgumentException("Invalid Reply");
        }
    }

    protected int receiveReply(int range) {
        // Scanner can purposefully wait till nextInt and therefore doesn't need much error handling, in contrast to
        // BufferReader
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
