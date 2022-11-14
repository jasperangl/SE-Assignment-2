/**
 * Gruppe H7
 * Jasper Angl (108021103663)
 * Philipp Lehmann (108021228860)
 * Malte Janek Kottmann (108021220217)
 */
public class Kitchen extends Room {

    private boolean stoveOn;

    public Kitchen(String name, boolean lightning, boolean stoveOn) {
        super(name, lightning);
        this.stoveOn = stoveOn;
    }

    public void switchStove() {
        this.stoveOn = !this.stoveOn;
    }

    public boolean stoveOn() {
        return this.stoveOn;
    }

    @Override
    protected void enter() {
        System.out.println("You're in the " + this.getName());
        System.out.println("What do you want to do?");
        System.out.println("1) Switch Light setting");
        System.out.println("2) Enter neighbor room");
        System.out.println("3) Leave room");
        System.out.println("4) Turn on/off stove");
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
            this.switchStove();
            this.enter();
        }
    }
}
