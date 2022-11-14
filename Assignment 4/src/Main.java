import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Apartment apartment = createApartment();
        apartment.enter();
    }

    private static Apartment createApartment() {
        Apartment apartment = new Apartment();
        Room workroom = new Room("Workroom");
        Room bedroom = new Room("Bedroom");
        Kitchen kitchen = new Kitchen("Kitchen");
        Bathroom bathroom = new Bathroom("Bathroom");
        //TODO: extensions don't add neighbors correctly yet
        apartment.addNewRoom(workroom);
        apartment.addNewRoom(bedroom);
        apartment.addNewRoom(kitchen);
        apartment.addNewRoom(bathroom);

        workroom.addNeighbor(bedroom);


        return apartment;
    }
}
