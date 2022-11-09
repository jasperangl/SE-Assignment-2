public class Bathroom extends Room{

    private boolean shower;

    public Bathroom(String name, boolean lightning, boolean shower) {
        super(name, lightning);
        this.shower = shower;
    }

    public boolean turnShower() {
        this.shower = !this.shower;
        return this.shower;
    }

    public boolean showerOn() {
        return this.shower;
    }

    @Override
    protected void enter() {
        super.enter(); // Change here according to room
    }

    @Override
    protected int receiveReply() {
        return super.receiveReply(); // Change here according to room
    }
}
