package maciek.przewor;

import java.util.*;

public class RoomManager {

    public void creatingRooms() {

        Scanner scan = new Scanner(System.in);
        Room room = new Room();

        System.out.println("Numer pokoju:");
        room.number = Integer.parseInt(scan.nextLine());
        for (Room r : Main.roomDatabase) {
            while (room.number == r.number) {
                System.out.println("Istnieje już pokój o takim numerze. Podaj inny numer:");
                room.number = Integer.parseInt(scan.nextLine());
            }
        }

        System.out.println("Ilość łóżek:");
        room.beds = Integer.parseInt(scan.nextLine());

        System.out.println("Metraż:");
        room.floor = Double.parseDouble(scan.nextLine());

        System.out.println("Czy w pokoju jest balkon? Odpowiedz TAK lub NIE:");
        room.balcony = scan.nextLine();

        Main.roomDatabase.add(room);

    }

    public void editingRooms() {

        GUI.roomList();

        System.out.println("Podaj numer pokoju, który chcesz edytować:");
        Scanner scan = new Scanner(System.in);
        int editRoom = Integer.parseInt(scan.nextLine());
        for (Room room : Main.roomDatabase) {

            if (editRoom == room.number) {

                System.out.println("Numer pokoju:");
                room.number = Integer.parseInt(scan.nextLine());

                for (Room r : Main.roomDatabase) {

                    while (r.number == room.number && Main.roomDatabase.indexOf(r) != Main.roomDatabase.indexOf(room)) {
                        System.out.println("Istnieje już pokój o takim numerze. Podaj inny numer:");
                        room.number = Integer.parseInt(scan.nextLine());
                    }
                }

                System.out.println("Ilość łóżek:");
                room.beds = Integer.parseInt(scan.nextLine());

                System.out.println("Metraż:");
                room.floor = Double.parseDouble(scan.nextLine());

                System.out.println("Czy w pokoju jest balkon? Odpowiedz TAK lub NIE:");
                room.balcony = scan.nextLine();
                break;
            }
        }
    }
}