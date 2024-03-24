package lab_3;

import java.time.LocalDate;
import java.util.*;

public class Concert extends Attraction implements Visitable, Payable{

    private Map<LocalDate, TimeInterval> timeTable;
    private double ticketPrice;

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return this.timeTable;
    }

    @Override
    public double getTicketPrice() {
        return this.ticketPrice;
    }

    public Concert() {

    }
    public Concert(Map<LocalDate, TimeInterval> timeTable, double ticketPrice) {
        this.timeTable = timeTable;
        this.ticketPrice = ticketPrice;
    }

    public void setTimeTable(Map<LocalDate, TimeInterval> timeTable) {
        this.timeTable = timeTable;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "name='" + this.getName() + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}