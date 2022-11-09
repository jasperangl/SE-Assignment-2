import java.io.IOException;

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
        apartment.extension(workroom);
        apartment.extension(bedroom);
        apartment.extension(kitchen);
        apartment.extension(bathroom);
        return apartment;
    }
}
