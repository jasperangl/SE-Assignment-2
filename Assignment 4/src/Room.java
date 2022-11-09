import java.util.ArrayList;
import java.util.Scanner;

public class Room {
    private String name;
    private boolean lightning;
    private ArrayList<Room> neighbors;
    public Room(String name, boolean lightning) {
        this.name = name;
        this.lightning = lightning;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Room room) {
        this.neighbors.add(room);
    }

    public void switchLight() {
        this.lightning = !this.lightning;
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
        int reply = this.receiveReply();
        //TODO: Act accordingly to reply

        if (reply == 1) {
            this.switchLight();
            if (this.lightning) {
                System.out.println("Light has been turned on");
            } else {
                System.out.println("Light has been turned off");
            }
        }
        //TODO: 2) Enter neighbor room: Give list of all neighbor
        //TODO: 3) Leave Room: Has to leave into the previous room
    }

    protected int receiveReply() {
        // Scanner can purposefully wait till nextInt and therefore doesn't need much error handling, in contrast to
        // BufferReader
        Scanner reader = new Scanner(System.in);
        int answer = reader.nextInt();
        if (answer > 0 && answer < 3) {
            return answer;
        } else {
            throw new IllegalArgumentException("Wrong integer input");
        }

    }
}
