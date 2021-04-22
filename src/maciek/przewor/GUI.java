package maciek.przewor;

public class GUI {

    public static void welcome() {

        System.out.println("█████████████████████████████████████████████████████████████████████████");
        System.out.println("█─█─██▀▄─████▄─▄█─▄▄▄▄████▀▄─██▄─▀█▄─▄█▄─▄▄▀███▄─▀█▄─▄██▀▄─████▄─▄█─▄▄▄▄█");
        System.out.println("█─▄─██─▀─██─▄█─██▄▄▄▄─████─▀─███─█▄▀─███─██─████─█▄▀─███─▀─██─▄█─██▄▄▄▄─█");
        System.out.println("▀▄▀▄▀▄▄▀▄▄▀▄▄▄▀▀▀▄▄▄▄▄▀▀▀▄▄▀▄▄▀▄▄▄▀▀▄▄▀▄▄▄▄▀▀▀▀▄▄▄▀▀▄▄▀▄▄▀▄▄▀▄▄▄▀▀▀▄▄▄▄▄▀");

        System.out.println("Witamy w panelu administratora Hotelu 'Hajs and Najs'! Wybierz:");

    }

    public static void menu() {

        System.out.println("1. Lista wolnych pokoi.");
        System.out.println("2. Lista rezerwacji.");
        System.out.println("3. Tworzenie pokoju.");
        System.out.println("4. Edycja pokoju.");
        System.out.println("5. Rezerwacja pokoju.");
        System.out.println("6. Usunięcie rezerwacji.");
        System.out.println("0. Wyjście.");

    }

    public static void roomList() {

        System.out.println("Oto lista pokoi:");
        System.out.println("Numer | Ilość łóżek | Metraż | Balkon");
        for (Room room : Main.roomDatabase) {

            System.out.println(room);
        }

    }

    public static void freeRooms() {

        System.out.println("Oto lista wolnych pokoi:");
        System.out.println("Numer | Ilość łóżek | Metraż | Balkon");
        for (Room room : Main.roomDatabase) {

            if (room.booking.isEmpty()) {

                System.out.println(room);
            }

        }
    }

    public static void bookingList() {
        System.out.println("Oto lista rezerwacji:");
        System.out.println("Pokój | Imię i nazwisko | Ilość osób | Od kiedy | Ilość dni");
        for (Room r : Main.roomDatabase) {
            for (Booking b : r.booking) {
                System.out.println(r.number + "   | " + b);
            }
        }

    }

}
