package lab_3;

import com.sun.source.tree.WhileLoopTree;

import java.time.LocalDate;
import java.util.*;

public class Trip {
    private String cityName;
    private LocalDate start, end;
    private List<Attraction> attractions = new ArrayList<>();

    public Trip () {}
    public Trip (String cityName, LocalDate start, LocalDate end) {
        this.cityName = cityName;
        this.start = start;
        this.end = end;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public void addAttraction (Attraction attraction) {
        this.attractions.add(attraction);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "cityName='" + cityName + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", attractions=" + attractions +
                '}';
    }

    public void displayNotPayable(LocalDate date) {
        List<Attraction> visitables = new ArrayList<>();
        for (Attraction i : attractions) {
            if (i instanceof Visitable && !(i instanceof Payable)) {
                visitables.add(i);
            }
        }
        Comparator<Attraction> comparator = Comparator.comparing(attraction -> {
            Visitable visitableAttraction = (Visitable) attraction;
            return visitableAttraction.getOpeningHour(date);
        });
        visitables.sort(comparator);
        System.out.println("Not payable attractions are: ");
        for (Attraction j : visitables) {
            Visitable visitableAttraction = (Visitable) j;
            System.out.println(j.getName() + ", opening Hour: " + visitableAttraction.getOpeningHour(date));
        }
    }

    public Map<LocalDate, TimeInterval> createMap() {
        Map<LocalDate, TimeInterval> map = new HashMap<LocalDate, TimeInterval>();
        LocalDate date = this.getStart();
        while (!date.isEqual(this.getEnd())){
            map.put(date, null);
            date = date.plusDays(1);
        }
        return map;
    }
}