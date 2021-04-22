package maciek.przewor;

import java.util.Scanner;

public class BookingManager {

    public void creatingBooking() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Imię:");
        String firstName = scan.nextLine();

        System.out.println("Nazwisko:");
        String name = scan.nextLine();

        System.out.println("Ilość osób:");
        int people = Integer.parseInt(scan.nextLine());

        System.out.println("Numer pokoju:");
        int roomNumber = Integer.parseInt(scan.nextLine());

        System.out.println("Dzień:");
        int day = Integer.parseInt(scan.nextLine());

        System.out.println("Miesiąc:");
        int month = Integer.parseInt(scan.nextLine());

        System.out.println("Rok:");
        int year = Integer.parseInt(scan.nextLine());

        System.out.println("Ilość dni:");
        int duration = Integer.parseInt(scan.nextLine());

        Booking booking = new Booking(firstName, name, day, month, year, duration, people);
        for (Room r : Main.roomDatabase) {
            if (roomNumber == r.number) {
                boolean free = true;
                for (Booking b : r.booking) {
                    if (!(booking.check_out.isBefore(b.check_in) ||
                            booking.check_in.isAfter(b.check_out))) {
                        free = false;
                        break;
                    }
                }
                if (free) {
                    r.booking.add(booking);
                } else {
                    System.out.println("Ten pokój jest już zarezerwowany w tym terminie. Popraw swoją rezerwację.");
                }
            }
        }
    }

    public void removingBooking() {

        Scanner scan = new Scanner(System.in);

        String firstName;
        String name;

        int day;
        int month;
        int year;

        System.out.println("Podaj imię:");
        firstName = scan.nextLine();

        System.out.println("Podaj nazwisko:");
        name = scan.nextLine();

        System.out.println("Podaj dzień:");
        day = Integer.parseInt(scan.nextLine());

        System.out.println("Podaj miesiąc:");
        month = Integer.parseInt(scan.nextLine());

        System.out.println("Podaj rok:");
        year = Integer.parseInt(scan.nextLine());

        for (Room room : Main.roomDatabase) {
            for (Booking booking : room.booking) {
                if (firstName.equals(booking.firstName) && name.equals(booking.name) &&
                        day == booking.check_in.getDayOfMonth() && month == booking.check_in.getMonthValue() && year == booking.check_in.getYear()) {
                    room.booking.remove(booking);
                    break;
                }
            }
        }
    }
}






