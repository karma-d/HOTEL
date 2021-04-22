package maciek.przewor;

import java.util.ArrayList;

public class Room {

    int number;
    int beds;
    double floor;
    String balcony;

    ArrayList<Booking> booking = new ArrayList<>();

    public Room() {

    }

    public Room(String number, String beds, String floor, String balcony, ArrayList<Booking> booking) {
        this.number = Integer.parseInt(number);
        this.beds = Integer.parseInt(beds);
        this.floor = Double.parseDouble(floor);
        this.balcony = balcony;
        this.booking = booking;
    }

    @Override
    public String toString() {
        return this.number + "    | " + this.beds + "           | " + this.floor + "    | " + this.balcony;
    }

}
