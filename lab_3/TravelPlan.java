package lab_3;

import java.time.LocalDate;
import java.util.*;

public class TravelPlan {
    private Trip trip;

    private List<Pair<LocalDate, Visitable>> visitSchedule = new ArrayList<>();

    public TravelPlan(){}

    public TravelPlan(Trip trip) {
        this.trip = trip;
    }

    public void addVisit (LocalDate date, Visitable visitableAttraction) {
        if (date.isBefore(trip.getStart()) || date.isAfter(trip.getEnd())) {
            System.out.println("Date is outside trip range!");
            return;
        }

        Map<LocalDate, TimeInterval> timetable = visitableAttraction.getTimetable();
        TimeInterval timeInterval = timetable.getOrDefault(date, null);
        if (timeInterval == null) {
            Attraction attraction = (Attraction) visitableAttraction;
            System.out.println("You cannot visit " + attraction.getName() + " in that day!");
            return;
        }
        Pair<LocalDate, Visitable> pair = new Pair<>(date, visitableAttraction);
        visitSchedule.add(pair);
    }

    @Override
    public String toString() {
        return "TravelPlan{" +
                "visitSchedule=" + visitSchedule +
                '}';
    }
}