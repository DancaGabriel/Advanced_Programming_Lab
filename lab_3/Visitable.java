package lab_3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public interface Visitable {
    Map<LocalDate, TimeInterval> getTimetable();

    default LocalTime getOpeningHour(LocalDate date) {
        LocalTime time;
        Map<LocalDate, TimeInterval> timeTable = getTimetable();
        if (timeTable.get(date) == null) {
            System.out.println("The attraction is not visitable on that date!");
            return null;
        }
        else {
            return timeTable.get(date).getFirst();
        }
    }

}