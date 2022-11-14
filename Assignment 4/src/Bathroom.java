import java.sql.Time;
import java.util.Timer;
/**
 * Gruppe H7
 * Jasper Angl (108021103663)
 * Philipp Lehmann (108021228860)
 * Malte Janek Kottmann (108021220217)
 */
public class Bathroom extends Room{

    private boolean showerOn;
    private long showerStartTime;

    public Bathroom(String name, boolean lightning, boolean showerOn) {
        super(name, lightning);
        this.showerOn = showerOn;
    }

    public void turnShower() {
        this.showerOn = !this.showerOn;
        if (this.showerOn) {
            System.out.println("Shower is turned on");
            this.showerStartTime = System.currentTimeMillis();
        } else {
            long showerEndTime = System.currentTimeMillis();
            long showerDuration = showerEndTime - showerStartTime;
            double waterConsumption = showerDuration * 0.2;
            System.out.println("Shower is turned off");
            System.out.println("You have consumed " + (int) waterConsumption  + " milliliters");
        }
    }

    public boolean showerOn() {
        return this.showerOn;

    }

    @Override
    protected void enter() {
        System.out.println("You're in the " + this.getName());
        System.out.println("What do you want to do?");
        System.out.println("1) Switch Light setting");
        System.out.println("2) Enter neighbor room");
        System.out.println("3) Leave room");
        System.out.println("4) Turn on/off shower");
        int reply = this.receiveReply(4);
        if (reply == 1) {
            this.switchLight();
            this.enter();
        }
        if (reply == 2) {
            this.enterNeighborRoom();
            this.enter(); // This will ensure you will always come back to the previous room upon leaving
        }
        if (reply == 3) {
            System.out.println("Leaving the " + this.getName());
        }
        if (reply == 4) {
            this.turnShower();
            this.enter();
        }
    }
}
