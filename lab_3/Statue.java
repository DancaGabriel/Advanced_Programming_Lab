package lab_3;

import java.time.LocalDate;
import java.util.Map;

public class Statue extends Attraction implements Visitable{
    private Map<LocalDate, TimeInterval> timeTable;

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timeTable;
    }

    public void setTimeTable(Map<LocalDate, TimeInterval> timeTable) {
        this.timeTable = timeTable;
    }

    @Override
    public String toString() {
        return "Statue{" +
                "name='" + this.getName() + '\'' +
                '}';
    }
}