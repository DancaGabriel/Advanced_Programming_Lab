package lab_3;

import java.time.LocalTime;

public class TimeInterval extends Pair<LocalTime, LocalTime> {

    public TimeInterval () {
        super();
    }
    public TimeInterval(LocalTime first, LocalTime second) {
        super(first, second);
    }
}