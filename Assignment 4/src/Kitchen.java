public class Kitchen extends Room {

    private boolean stove;

    public Kitchen(String name) {
        super(name);
        this.stove = false;
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
}
