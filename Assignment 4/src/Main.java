import java.io.IOException;
/**
 * Gruppe H7
 * Jasper Angl (108021103663)
 * Philipp Lehmann (108021228860)
 * Malte Janek Kottmann (108021220217)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Apartment apartment = createApartment();
        apartment.enter();
    }

    private static Apartment createApartment() {
        Apartment apartment = new Apartment();
        Room workroom = new Room("Workroom", false);
        Room bedroom = new Room("Bedroom", false);
        Kitchen kitchen = new Kitchen("Kitchen", false, false);
        Bathroom bathroom = new Bathroom("Bathroom", false, false);

        apartment.addNewRoom(workroom);
        apartment.addNewRoom(bedroom);
        apartment.addNewRoom(kitchen);
        apartment.addNewRoom(bathroom);

        workroom.addNeighbor(bedroom);


        return apartment;
    }
}
