package maciek.przewor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Database database = new Database();
    public static ArrayList<Room> roomDatabase = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        database.createRoomDatabase();
        database.createBookDatabase();

        RoomManager session = new RoomManager();
        BookingManager booking_session = new BookingManager();
        GUI.welcome();
        Scanner scan = new Scanner(System.in);

        boolean running = true;
        do {
            GUI.menu();

            switch (scan.nextInt()) {
                case 1:
                    GUI.freeRooms();
                    break;
                case 2:
                    GUI.bookingList();
                    break;
                case 3:
                    session.creatingRooms();
                    break;
                case 4:
                    session.editingRooms();
                    break;
                case 5:
                    booking_session.creatingBooking();
                    break;
                case 6:
                    booking_session.removingBooking();
                    break;
                case 0:
                    running = false;
                    Database.writeRoomDatabase();
                    Database.writeBookDatabase();
                    break;
            }
        } while (running);
    }
}
