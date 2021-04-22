package maciek.przewor;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Database {

    static String fullRoomPath = "/Users/jerzyprzeworski/Desktop/projekty/HOTEL - NEW VERSION/src/maciek/przewor/fileRoomDatabase.txt";
    static String fullBookPath = "/Users/jerzyprzeworski/Desktop/projekty/HOTEL - NEW VERSION/src/maciek/przewor/fileBookDatabase.txt";

    public void createRoomDatabase() {

        File fileRoomDatabase = new File(fullRoomPath);
        try {
            fileRoomDatabase.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileRoomDatabase.length() != 0) {
            try {
                List<String> lines = FileUtils.readLines(fileRoomDatabase, StandardCharsets.UTF_8);
                for (String line : lines) {
                    String[] lineRooms = line.split(" ");
                    ArrayList<Booking> booking = new ArrayList<>();
                    Room room = new Room(lineRooms[0], lineRooms[1], lineRooms[2], lineRooms[3], booking);
                    Main.roomDatabase.add(room);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createBookDatabase() {

        File fileBookDatabase = new File(fullBookPath);
        try {
            fileBookDatabase.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fileBookDatabase.length() != 0) {
            try {
                List<String> lines = FileUtils.readLines(fileBookDatabase, StandardCharsets.UTF_8);
                for (String line : lines) {

                    String[] lineBooks = line.split(" ");
                    for (Room room : Main.roomDatabase) {

                        if (Integer.parseInt(lineBooks[0]) == room.number) {

                            Booking booking = new Booking(lineBooks[1], lineBooks[2], lineBooks[3], lineBooks[4], lineBooks[5], lineBooks[6]);
                            room.booking.add(booking);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeRoomDatabase() {

        ArrayList<String> fileRoom = new ArrayList<>();

        for (Room room : Main.roomDatabase) {

            String line = room.number + " " + room.beds + " " + room.floor + " " + room.balcony;
            fileRoom.add(line);

        }
        try {
            FileUtils.writeLines(new File(Database.fullRoomPath), fileRoom);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeBookDatabase() {

        ArrayList<String> fileBook = new ArrayList<>();

        for (Room room : Main.roomDatabase) {

            for (Booking booking : room.booking) {

                String line = room.number + " " + booking.firstName + " " + booking.name + " " + booking.duration +
                        " " + booking.check_in + " " + booking.check_out + " " + booking.people;
                fileBook.add(line);

            }

        }
        try {
            FileUtils.writeLines(new File(Database.fullBookPath), fileBook);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
