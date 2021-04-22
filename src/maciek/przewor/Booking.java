package maciek.przewor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Booking {

    String firstName;
    String name;
    int duration;
    LocalDate check_in;
    LocalDate check_out;
    int people;

    public Booking(String firstName, String name, int day, int month, int year, int duration, int people) {
        this.firstName = firstName;
        this.name = name;
        this.duration = duration;
        this.people = people;
        this.check_in = LocalDate.of(year, month, day);
        this.check_out = check_in.plusDays(duration);
    }

    public Booking(String firstName, String name, String duration, String check_in, String check_out, String people) {
        this.firstName = firstName;
        this.name = name;
        this.duration = Integer.parseInt(duration);
        this.check_in = LocalDate.parse(check_in, DateTimeFormatter.ISO_DATE);
        this.check_out = LocalDate.parse(check_out, DateTimeFormatter.ISO_DATE);
        this.people = Integer.parseInt(people);
    }

    @Override
    public String toString() {
        return firstName + " " + this.name + " | " + this.people + " | " + check_in.format(DateTimeFormatter.ISO_DATE) + " <-> " + check_out.format(DateTimeFormatter.ISO_DATE);
    }
}
