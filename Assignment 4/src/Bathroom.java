import java.sql.Time;
import java.util.Timer;

public class Bathroom extends Room{

    private boolean shower;
    private long showerStartTime;

    public Bathroom(String name) {
        super(name);
        this.shower = false;
    }

    public boolean turnShower() {
        this.shower = !this.shower;
        if (this.shower) {
            System.out.println("Shower is turned on");
            this.showerStartTime = System.currentTimeMillis();
        } else {
            long showerEndTime = System.currentTimeMillis();
            long showerDuration = (showerEndTime - showerStartTime);
            int waterConsumption = (int) (showerDuration * 0.2);
            System.out.println(showerDuration);
            System.out.println("In seconds: " + showerDuration/1000);
            System.out.println("Shower is turned off");
            System.out.println("You have consumed " + waterConsumption  + " milliliters");
        }
        return this.shower;
    }

    public boolean showerOn() {
        return this.shower;
    }

    @Override
    protected void enter() {
        super.enter();
        //TODO: Change here according to room
    }
}
