public class Kitchen extends Room {

    private boolean stove;

    public Kitchen(String name, boolean lightning, boolean stove) {
        super(name, lightning);
        this.stove = stove;
    }

    public boolean switchStove() {
        this.stove = !this.stove;
        return this.stove;
    }

    public boolean stoveOn() {
        return this.stove;
    }

    @Override
    protected void enter() {
        super.enter(); // change here according to room
    }

    protected int receiveReply() {
        return super.receiveReply(); // Change here according to room
    }
}
