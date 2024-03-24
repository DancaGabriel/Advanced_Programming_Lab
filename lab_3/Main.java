package lab_3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Trip trip = new Trip("Iasi", LocalDate.of(2024, 3, 18), LocalDate.of(2024, 3, 25));
        Map<LocalDate, TimeInterval> timetable = trip.createMap();
        ArrayList<Attraction> attractions = new ArrayList<>();

        //statue
        Statue statue1 = new Statue();
        statue1.setName("Stefan cel Mare");
        TimeInterval statueInterval = new TimeInterval();
        statueInterval.setFirst(LocalTime.of(8, 0));
        statueInterval.setSecond(LocalTime.of(22, 0));
        LocalDate date = trip.getStart();
        Map<LocalDate, TimeInterval> statueTime = new HashMap<>();
        statueTime.putAll(timetable);
        while (!date.isEqual(trip.getEnd())){
            statueTime.putIfAbsent(date, statueInterval);
            date = date.plusDays(1);
        }
        statue1.setTimeTable(statueTime);
        attractions.add(statue1);

        //concert
        Concert concert1 = new Concert();
        concert1.setName("Cargo");
        TimeInterval concertInterval = new TimeInterval();
        concertInterval.setFirst(LocalTime.of(18, 0));
        concertInterval.setSecond(LocalTime.of(0, 0));
        Map<LocalDate, TimeInterval> concertTime = new HashMap<>();
        concertTime.putAll(timetable);
        concertTime.putIfAbsent(LocalDate.of(2024, 3, 23), concertInterval);
        concertTime.putIfAbsent(LocalDate.of(2024, 3, 24), concertInterval);
        concert1.setTimeTable(concertTime);
        concert1.setTicketPrice(35);
        attractions.add(concert1);

        //church
        Church church1 = new Church();
        church1.setName("Sf. Vineri");
        TimeInterval churchInterval = new TimeInterval();
        churchInterval.setFirst(LocalTime.of(7, 0));
        churchInterval.setSecond(LocalTime.of(16, 30));
        Map<LocalDate, TimeInterval> churchTime = trip.createMap();
        churchTime.putIfAbsent(LocalDate.of(2024, 3, 23), churchInterval);
        churchTime.putIfAbsent(LocalDate.of(2024, 3, 24), churchInterval);
        church1.setTimeTable(churchTime);
        attractions.add(church1);

        trip.setAttractions(attractions);
        trip.displayNotPayable(LocalDate.of(2024, 3, 23));

        TravelPlan planA = new TravelPlan(trip);
        planA.addVisit(LocalDate.of(2024, 3, 24), statue1);
        planA.addVisit(LocalDate.of(2024, 3, 23), concert1);
        planA.addVisit(LocalDate.of(2024, 3, 24), church1);
        System.out.println("");
        System.out.println(planA);
    }
}